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
	
	public boolean execution(String content,String execution);
	public boolean executionds1(String content,String execution);
	public boolean executionds2(String content,String execution);
	public boolean executionds3(String content,String execution);
	public Integer queryExecution(String query);
}
