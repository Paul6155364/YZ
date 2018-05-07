package com.cn.iris.submission.entity;

import java.io.Serializable;

/**
 * submission
 * @author 
 */
public class SubmissionWithBLOBs extends Submission implements Serializable {
    /**
     * SQL内容
     */
    private String content;

    /**
     * 查询语句
     */
    private String query;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
        SubmissionWithBLOBs other = (SubmissionWithBLOBs) that;
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
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getQuery() == null ? other.getQuery() == null : this.getQuery().equals(other.getQuery()));
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
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getQuery() == null) ? 0 : getQuery().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", content=").append(content);
        sb.append(", query=").append(query);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}