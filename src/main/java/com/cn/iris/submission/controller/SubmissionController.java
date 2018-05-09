package com.cn.iris.submission.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.cn.iris.admin.entity.User;
import com.cn.iris.common.util.AjaxRetBean;
import com.cn.iris.common.util.ResWriteUtil;
import com.cn.iris.common.util.sql.SqlParserUtil;
import com.cn.iris.submission.entity.Datasource;
import com.cn.iris.submission.entity.SubmissionWithBLOBs;
import com.cn.iris.submission.service.IDatasourceService;
import com.cn.iris.submission.service.ISubmissionService;


/**
 * @Author: IrisNew
 * @Description: 用户Controller
 * @Date: 2017/12/7 17:03
 */
@Controller
@RequestMapping("/submission")
public class SubmissionController {

    private Logger logger = LoggerFactory.getLogger(SubmissionController.class);

    @Autowired
    private ISubmissionService submissionServiceImpl;
    @Autowired
    private IDatasourceService datasourceServiceImpl;

    @GetMapping("/index")
    public String index() {
        return "/submission/list";
    }

    @GetMapping("/list")
    @ResponseBody
    public Page<SubmissionWithBLOBs> listUsers(Integer pageSize, Integer pageNumber,HttpServletRequest request) {
    	User user = (User) request.getSession().getAttribute("iris_user");
        Page<SubmissionWithBLOBs> page = submissionServiceImpl.selectSubmissionPage(new Page<>(pageNumber, pageSize),user.getId().toString());
        return page;
    }

    @GetMapping("/add")
    public String addUser(){
    	
        return "/submission/addForm";
    }

    @PostMapping("/show")
    @Transactional
    public void showUser(@RequestParam String id,HttpServletResponse response){
    	 AjaxRetBean<JSONObject> returnBean =  new AjaxRetBean<> ();
    	 boolean flag=false;
         try {
         	SubmissionWithBLOBs submissionWithBLOBs = submissionServiceImpl.selectById(id);
             if(submissionWithBLOBs != null && submissionWithBLOBs.getId() != null){
            	 Integer status = submissionWithBLOBs.getStatus();
            	 if(status==1) {
                      String content = submissionWithBLOBs.getContent();
                      String dataSource = submissionWithBLOBs.getDataSource();
                      submissionWithBLOBs.setExecutionTime(new Date());
                      Datasource dbsource = datasourceServiceImpl.dbchose(dataSource);
                      Integer results = submissionServiceImpl.execution(content, dbsource.getDrive(), dbsource.getUrl(), dbsource.getUsername(), dbsource.getPassword());
                      submissionWithBLOBs.setResults(results.toString());
                      submissionServiceImpl.updateSubmissionById(submissionWithBLOBs);
                      if(results>0){  
                    	  flag=true; 
                      } 
            	 }
                 if(flag){
                     returnBean.setSuccess(true);
                     returnBean.setMessage("执行成功！");
                 }else{
                     returnBean.setSuccess(false);
                     returnBean.setMessage("执行失败！");
                 }
             }else {
                 returnBean.setSuccess(false);
                 returnBean.setMessage("SQL不存在！");
             }
         }catch (Exception e){
             logger.error(e.getMessage());
             returnBean.setSuccess(false);
             returnBean.setMessage("执行失败："+e.getMessage());
         }
         ResWriteUtil.writeObject(response,returnBean);
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam String id,Model model){
        if(id != null){
        	SubmissionWithBLOBs submissionWithBLOBs = submissionServiceImpl.selectById(id);
            if(submissionWithBLOBs != null && submissionWithBLOBs.getId() != null){
            	Datasource dbsource = datasourceServiceImpl.dbchose(submissionWithBLOBs.getDataSource());
                model.addAttribute("submissionWithBLOBs",submissionWithBLOBs);
                model.addAttribute("dbsource",dbsource);
                return "/submission/editForm";
            }
        }
        return "error/404";
    }

    @PostMapping("/saveAdd")
    public void saveAdd(HttpServletResponse response,HttpServletRequest request){
    	User user = (User) request.getSession().getAttribute("iris_user");
    	String content = request.getParameter("content").replaceAll("'", "\\'");
    	String query = request.getParameter("query").replaceAll("'", "\\'");
    	String dataSource = request.getParameter("dataSource");
    	String queryresults = request.getParameter("queryresults");
    	String overdueResults = request.getParameter("overdueresults");
    	String execution = request.getParameter("execution");
    	SubmissionWithBLOBs submissionWithBLOBs = new SubmissionWithBLOBs();
    	UUID uuid = UUID.randomUUID();  
        String strID = uuid.toString().replaceAll("-", "");  
    	submissionWithBLOBs.setId(strID);
        AjaxRetBean<JSONObject> returnBean =  new AjaxRetBean<> ();
        submissionWithBLOBs.setOwnerId(user.getId().toString());
        submissionWithBLOBs.setModify(new Date());
        submissionWithBLOBs.setContent(content);
        submissionWithBLOBs.setQuery(query);
        submissionWithBLOBs.setDataSource(dataSource);
        submissionWithBLOBs.setQueryResults(queryresults);
        submissionWithBLOBs.setStatus(1);
        submissionWithBLOBs.setOverdueResults(overdueResults);
        submissionWithBLOBs.setExecution(execution);
        try {
            boolean suc = submissionServiceImpl.insert(submissionWithBLOBs);
            if(suc){
                logger.info("新增SQL成功："+user.toString());
                returnBean.setSuccess(true);
                returnBean.setMessage("新增SQL成功！");
            }else{
                returnBean.setSuccess(false);
                returnBean.setMessage("新增SQL失败！");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            returnBean.setSuccess(false);
            returnBean.setMessage(e.getMessage());
        }
        ResWriteUtil.writeObject(response,returnBean);
    }
    @Transactional
    @PostMapping("/saveEdit")
    public void saveEdit(HttpServletRequest request,HttpServletResponse response){
        AjaxRetBean<JSONObject> returnBean =  new AjaxRetBean<> ();
        String content = request.getParameter("content").replaceAll("'", "\\'");
    	String query = request.getParameter("query").replaceAll("'", "\\'");
    	String dataSource = request.getParameter("dataSource");
    	String queryresults = request.getParameter("queryresults");
    	String overdueResults = request.getParameter("overdueresults");
    	String execution = request.getParameter("execution");
    	SubmissionWithBLOBs submissionWithBLOBs = new SubmissionWithBLOBs();
    	String id = request.getParameter("id");
    	submissionWithBLOBs.setId(id);
    	submissionWithBLOBs.setContent(content);
    	submissionWithBLOBs.setQuery(query);
    	submissionWithBLOBs.setDataSource(dataSource);
    	submissionWithBLOBs.setQueryResults(queryresults);
    	submissionWithBLOBs.setOverdueResults(overdueResults);
    	submissionWithBLOBs.setExecution(execution);
    	submissionWithBLOBs.setModify(new Date());
        try {
               
                boolean suc =  submissionServiceImpl.updateSubmissionById(submissionWithBLOBs);
                if(suc){
                    logger.info("修改SQL成功：");
                    returnBean.setSuccess(true);
                    returnBean.setMessage("修改SQL成功！");
                }else{
                    returnBean.setSuccess(false);
                    returnBean.setMessage("修改SQL失败！");
                }
        }catch (Exception e){
            logger.error(e.getMessage());
            returnBean.setSuccess(false);
            returnBean.setMessage("修改失败："+e.getMessage());
        }
        ResWriteUtil.writeObject(response,returnBean);
    }

    @PostMapping("/delUser")
    public void delete(@RequestParam String id,HttpServletResponse response){
        AjaxRetBean<JSONObject> returnBean =  new AjaxRetBean<> ();
        try {
        	SubmissionWithBLOBs submissionWithBLOBs = submissionServiceImpl.selectById(id);
            if(submissionWithBLOBs != null && submissionWithBLOBs.getId() != null){
                boolean flag = submissionServiceImpl.deleteById(id);
                if(flag){
                    returnBean.setSuccess(true);
                }else{
                    returnBean.setSuccess(false);
                    returnBean.setMessage("删除失败！");
                }
            }else {
                returnBean.setSuccess(false);
                returnBean.setMessage("SQL不存在！");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            returnBean.setSuccess(false);
            returnBean.setMessage("删除失败："+e.getMessage());
        }
        ResWriteUtil.writeObject(response,returnBean);
    }
    @ResponseBody
    @RequestMapping(value="/loadSelect",produces = "application/json;charset=UTF-8")
    public Map<String, Object> loadSelect() {
    	List<Datasource> dbList = datasourceServiceImpl.loadSelect();
        //以json格式的形式返回数据到前台easyui控件  
        Map<String,Object> result = new HashMap<String, Object>();  
        result.put("dbList", dbList);  
        return result; 
    }
    @ResponseBody
    @RequestMapping(value="/dbchose",produces = "application/json;charset=UTF-8")
    public Map<String, Object> dbchose(@RequestParam String db) {
    	Datasource dbsource = datasourceServiceImpl.dbchose(db);
        //以json格式的形式返回数据到前台easyui控件  
        Map<String,Object> result = new HashMap<String, Object>();  
        result.put("dbList", dbsource);  
        return result; 
    }
    @ResponseBody
    @RequestMapping(value="/populated",produces = "application/json;charset=UTF-8")
    public Map<String, Object> populated(@RequestParam String db) {
    	String sql =  db.trim().toLowerCase().replace("\\s{1,}", " ");
    	String sqly ="";
    	System.out.println(sql);
		int intInsert = sql.substring(0, 12).indexOf("insert");
		int intDelete = sql.substring(0, 12).indexOf("delete"); 
		int intUpdate = sql.substring(0, 12).indexOf("update"); 
		if(intInsert == - 1&&intDelete==-1&&intUpdate == - 1){  
		       System.out.println("没有找到字符串");
		}else if(intInsert != - 1&&intDelete==-1&&intUpdate == - 1){
		       sqly="select count(*) from "+sql.substring(11,sql.indexOf("("));
		       System.out.println("sqly 字符串位置:" + sqly); 
		} 
		else if(intInsert == - 1&&intDelete!=-1&&intUpdate == - 1){
		       sqly=sql.replace("delete", "select count(*)");
		       System.out.println("sqly 字符串位置:" + sqly); 
		} 
		else if(intInsert == - 1&&intDelete==-1&&intUpdate != - 1){
	       sqly="select count(*) from "+sql.substring(7,sql.indexOf("set"))+" "+sql.substring(sql.indexOf("where"));
	       System.out.println("sqly 字符串位置:" + sqly); 
	    }  
        //以json格式的形式返回数据到前台easyui控件  
        Map<String,Object> result = new HashMap<String, Object>();  
        result.put("sql", sqly);  
        return result; 
    }
    @ResponseBody
    @RequestMapping(value="/doquery",produces = "application/json;charset=UTF-8")
    public Map<String, Object> doquery(@RequestParam String db,@RequestParam String query) {
    	Datasource dbsource = datasourceServiceImpl.dbchose(db);
    	Integer count = submissionServiceImpl.queryExecution(query.replaceAll("'", "\\'"),dbsource.getDrive(),dbsource.getUrl(),dbsource.getUsername(),dbsource.getPassword());
        //以json格式的形式返回数据到前台easyui控件  
        Map<String,Object> result = new HashMap<String, Object>();  
        result.put("count", count);  
        return result; 
    }
    

}
