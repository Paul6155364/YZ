package com.cn.iris.submission.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * submission
 * @author 
 */
@TableName("submission")
public class Submission implements Serializable {
    private String id;

    /**
     * 1/审核通过 0/审核不通过
     */
    private Integer status;

    /**
     * 提交人ID
     */
    private String ownerId;

    /**
     * 审核人ID
     */
    private String auditorId;

    /**
     * 最后修改时间
     */
    private Date modify;

    /**
     * 执行操作
     */
    private String execution;

    /**
     * 执行时间
     */
    private Date executionTime;

    /**
     * 执行结果
     */
    private String results;

    /**
     * 查询结果
     */
    private String queryResults;

    /**
     * 预期结果
     */
    private String overdueResults;

    /**
     * 数据源
     */
    private String dataSource;
    @TableField(exist=false)
    private String owner;
    @TableField(exist=false)
    private String auditor;
    
    public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    public Date getModify() {
        return modify;
    }

    public void setModify(Date modify) {
        this.modify = modify;
    }

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getQueryResults() {
        return queryResults;
    }

    public void setQueryResults(String queryResults) {
        this.queryResults = queryResults;
    }

    public String getOverdueResults() {
        return overdueResults;
    }

    public void setOverdueResults(String overdueResults) {
        this.overdueResults = overdueResults;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Submission other = (Submission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getAuditorId() == null ? other.getAuditorId() == null : this.getAuditorId().equals(other.getAuditorId()))
            && (this.getModify() == null ? other.getModify() == null : this.getModify().equals(other.getModify()))
            && (this.getExecution() == null ? other.getExecution() == null : this.getExecution().equals(other.getExecution()))
            && (this.getExecutionTime() == null ? other.getExecutionTime() == null : this.getExecutionTime().equals(other.getExecutionTime()))
            && (this.getResults() == null ? other.getResults() == null : this.getResults().equals(other.getResults()))
            && (this.getQueryResults() == null ? other.getQueryResults() == null : this.getQueryResults().equals(other.getQueryResults()))
            && (this.getOverdueResults() == null ? other.getOverdueResults() == null : this.getOverdueResults().equals(other.getOverdueResults()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getAuditorId() == null) ? 0 : getAuditorId().hashCode());
        result = prime * result + ((getModify() == null) ? 0 : getModify().hashCode());
        result = prime * result + ((getExecution() == null) ? 0 : getExecution().hashCode());
        result = prime * result + ((getExecutionTime() == null) ? 0 : getExecutionTime().hashCode());
        result = prime * result + ((getResults() == null) ? 0 : getResults().hashCode());
        result = prime * result + ((getQueryResults() == null) ? 0 : getQueryResults().hashCode());
        result = prime * result + ((getOverdueResults() == null) ? 0 : getOverdueResults().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", auditorId=").append(auditorId);
        sb.append(", modify=").append(modify);
        sb.append(", execution=").append(execution);
        sb.append(", executionTime=").append(executionTime);
        sb.append(", results=").append(results);
        sb.append(", queryResults=").append(queryResults);
        sb.append(", overdueResults=").append(overdueResults);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}