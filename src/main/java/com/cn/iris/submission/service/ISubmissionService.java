package com.cn.iris.submission.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.cn.iris.submission.entity.SubmissionWithBLOBs;

public interface ISubmissionService {
	/**
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<SubmissionWithBLOBs> selectSubmissionPage(Page<SubmissionWithBLOBs> page, String userId);
	/**
	 * 
	 * @param submissionWithBLOBs
	 * @return
	 */
	public boolean insert(SubmissionWithBLOBs submissionWithBLOBs);
	
	public SubmissionWithBLOBs selectById(String id);
	
	public boolean updateSubmissionById(SubmissionWithBLOBs submissionWithBLOBs);
	
	public boolean deleteById(String id);
	
	public Integer execution(String content,String driver,String url,String username,String password);
	public Integer queryExecution(String query,String driver,String url,String username,String password);
}
