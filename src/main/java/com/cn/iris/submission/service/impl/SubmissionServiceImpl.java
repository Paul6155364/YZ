package com.cn.iris.submission.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.cn.iris.common.config.datasource.TargetDataSource;
import com.cn.iris.common.util.JdbcUtil;
import com.cn.iris.submission.entity.SubmissionWithBLOBs;
import com.cn.iris.submission.mapper.SubmissionMapper;
import com.cn.iris.submission.service.ISubmissionService;
import com.cn.iris.submission.vo.SqlVo;
@Service
public class SubmissionServiceImpl implements ISubmissionService {
	// 定义数据库的链接  
    private Connection connection;  
  
    // 定义sql语句的执行对象  
    private PreparedStatement pstmt;  
  
    // 定义查询返回的结果集合  
    private ResultSet resultSet; 
	@Autowired
    private SubmissionMapper submissionMapper;

	@Override
	public Page<SubmissionWithBLOBs> selectSubmissionPage(Page<SubmissionWithBLOBs> page, String userId) {
		 page.setRecords(submissionMapper.selectSubmissionList(page,userId));
	return page;

}

	@Override
	public boolean insert(SubmissionWithBLOBs submissionWithBLOBs) {
		return submissionMapper.insert(submissionWithBLOBs);
	}

	@Override
	public SubmissionWithBLOBs selectById(String id) {
		
		return submissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateSubmissionById(SubmissionWithBLOBs submissionWithBLOBs) {
		// TODO Auto-generated method stub
		return submissionMapper.updateByPrimaryKeySelective(submissionWithBLOBs);
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return submissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer execution(String content,String driver,String url,String username,String password) {
		JdbcUtil jdbcUtil = null;  
        int count = 0;
        try {  
            jdbcUtil = new JdbcUtil();  
            connection = jdbcUtil.getConnection(driver, url, username, password); // 获取数据库链接  
            pstmt= connection.prepareStatement(content);//把写好的sql语句传递到数据库，让数据库知道我们要干什么  
            
            count=pstmt.executeUpdate();
            if(count>0){  
                System.out.println("操作成功");  
            }else{  
                System.out.println("操作失败");  
            }  
        } catch (SQLException e) {  
            System.out.println(this.getClass()+"增删改异常！");  
            e.printStackTrace();  
        } finally {  
            if (jdbcUtil != null) {  
                jdbcUtil.releaseConn(); // 一定要释放资源  
            }  
        }
		
		return count;
	}
	

	@Override
	public Integer queryExecution(String query,String driver,String url,String username,String password) {
		JdbcUtil jdbcUtil = null;  
        int count = 0;
        try {  
            jdbcUtil = new JdbcUtil();  
            connection = jdbcUtil.getConnection(driver, url, username, password); // 获取数据库链接  
            pstmt= connection.prepareStatement(query);//把写好的sql语句传递到数据库，让数据库知道我们要干什么  
            resultSet=pstmt.executeQuery();
            if(resultSet.next()) {
            count=resultSet.getInt(1);
            System.out.println("count:"+count);
            }
        } catch (SQLException e) {  
            System.out.println(this.getClass()+"执行预查询抛出异常！");  
            e.printStackTrace();  
        } finally {  
            if (jdbcUtil != null) {  
                jdbcUtil.releaseConn(); // 一定要释放资源  
            }  
        }
		return count;
	}
	/*// 使用数据源ds2
		@TargetDataSource("ds1")
	@Override
	public boolean executionds1(String content, String execution) {
		SqlVo sqlVo = new SqlVo();
		sqlVo.setSql(content);
		 boolean flag = false;
		if("insert".equals(execution)) {
			flag = submissionMapper.insertSqlVo(sqlVo);
		}else if("delete".equals(execution)) {
			flag = submissionMapper.deleteSqlVo(sqlVo);
		}else if("update".equals(execution)) {
			flag = submissionMapper.updateSqlVo(sqlVo);
		}else if("select".equals(execution)) {
			flag = submissionMapper.selectSqlVo(sqlVo);
		}
		return flag;
	}
	// 使用数据源ds2
	@TargetDataSource("ds2")
	@Override
	public boolean executionds2(String content, String execution) {
		SqlVo sqlVo = new SqlVo();
		sqlVo.setSql(content);
		 boolean flag = false;
		 JdbcUtil jdbcUtil = null;  
	        boolean bool = false;  
	        try {  
	            jdbcUtil = new JdbcUtil();  
	            conn = jdbcUtil.getConnection(); // 获取数据库链接  
	            ps= conn.prepareStatement(content);//把写好的sql语句传递到数据库，让数据库知道我们要干什么  
	            int a=ps.executeUpdate();
	            if(a>0){  
	                System.out.println("添加成功");  
	            }else{  
	                System.out.println("添加失败");  
	            }  
	        } catch (SQLException e) {  
	            System.out.println(this.getClass()+"执行更新操作抛出异常！");  
	            e.printStackTrace();  
	        } finally {  
	            if (jdbcUtil != null) {  
	                jdbcUtil.releaseConn(); // 一定要释放资源  
	            }  
	        }  
	        System.out.println("执行更新的结果："+flag); 
		if("insert".equals(execution)) {
			flag = submissionMapper.insertSqlVo(sqlVo);
		}else if("delete".equals(execution)) {
			flag = submissionMapper.deleteSqlVo(sqlVo);
		}else if("update".equals(execution)) {
			flag = submissionMapper.updateSqlVo(sqlVo);
		}else if("select".equals(execution)) {
			flag = submissionMapper.selectSqlVo(sqlVo);
		}
		return flag;
	}
	// 使用数据源ds2
	@TargetDataSource("ds3")
	@Override
	public boolean executionds3(String content, String execution) {
		SqlVo sqlVo = new SqlVo();
		sqlVo.setSql(content);
		 boolean flag = false;
		if("insert".equals(execution)) {
			flag = submissionMapper.insertSqlVo(sqlVo);
		}else if("delete".equals(execution)) {
			flag = submissionMapper.deleteSqlVo(sqlVo);
		}else if("update".equals(execution)) {
			flag = submissionMapper.updateSqlVo(sqlVo);
		}else if("select".equals(execution)) {
			flag = submissionMapper.selectSqlVo(sqlVo);
		}
		return flag;
	}*/
}