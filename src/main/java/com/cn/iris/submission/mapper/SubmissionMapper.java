package com.cn.iris.submission.mapper;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.cn.iris.submission.entity.Submission;
import com.cn.iris.submission.entity.SubmissionWithBLOBs;
import com.cn.iris.submission.vo.SqlVo;

public interface SubmissionMapper {
	boolean deleteByPrimaryKey(String id);

    public boolean insert(SubmissionWithBLOBs record);

    int insertSelective(SubmissionWithBLOBs record);

    SubmissionWithBLOBs selectByPrimaryKey(String id);

    public boolean updateByPrimaryKeySelective(SubmissionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SubmissionWithBLOBs record);

    int updateByPrimaryKey(Submission record);
    
    List<SubmissionWithBLOBs> selectSubmissionList(Page page, String userID);
    
    public boolean insertSqlVo(SqlVo sqlVo);
    public boolean deleteSqlVo(SqlVo sqlVo);
    public boolean updateSqlVo(SqlVo sqlVo);
    public boolean selectSqlVo(SqlVo sqlVo);
    Integer selectQuerySqlVo(SqlVo sqlVo);
    
}