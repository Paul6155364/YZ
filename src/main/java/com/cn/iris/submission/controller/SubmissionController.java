package com.cn.iris.submission.controller;

import java.util.Date;
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
import com.cn.iris.submission.entity.SubmissionWithBLOBs;
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
            		  String execution = submissionWithBLOBs.getExecution();
                      String content = submissionWithBLOBs.getContent();
                      String query = submissionWithBLOBs.getQuery();
                      String dataSource = submissionWithBLOBs.getDataSource();
                      if(dataSource.equals("ds1")) {
                    	  flag = submissionServiceImpl.executionds1(content, execution);
                      }else if(dataSource.equals("ds2")) {
                    	  flag = submissionServiceImpl.executionds2(content, execution);
                      }
                      //Integer count = submissionServiceImpl.queryExecution(query);
                      submissionWithBLOBs.setExecutionTime(new Date());
                      //submissionWithBLOBs.setQueryResults(count.toString());
                      submissionServiceImpl.updateSubmissionById(submissionWithBLOBs);
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
                model.addAttribute("submissionWithBLOBs",submissionWithBLOBs);
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
    	String auditorId = request.getParameter("auditorid");
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
        submissionWithBLOBs.setAuditorId(auditorId);
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
    	String auditorId = request.getParameter("auditorid");
    	String overdueResults = request.getParameter("overdueresults");
    	String execution = request.getParameter("execution");
    	SubmissionWithBLOBs submissionWithBLOBs = new SubmissionWithBLOBs();
    	String id = request.getParameter("id");
    	submissionWithBLOBs.setId(id);
    	submissionWithBLOBs.setContent(content);
    	submissionWithBLOBs.setQuery(query);
    	submissionWithBLOBs.setDataSource(dataSource);
    	submissionWithBLOBs.setAuditorId(auditorId);
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

}
