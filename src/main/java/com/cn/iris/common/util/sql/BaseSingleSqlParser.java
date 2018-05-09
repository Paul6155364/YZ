package com.cn.iris.common.util.sql;

import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * 单句sql解析器,单句即非嵌套的意思 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public abstract class BaseSingleSqlParser {  
  
    // 原始sql语句  
    protected String originalSql;  
    // sql语句片段  
    protected List<SqlSegment> segments;  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     */  
    public BaseSingleSqlParser(String originalSql) {  
        this.originalSql = originalSql;  
        segments = new ArrayList<>();  
        initializeSegments();  
        splitSqlToSegment();  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @return_type void 
     * 
     */  
    protected void splitSqlToSegment() {  
        for (SqlSegment sqlSegment : segments) {  
            sqlSegment.parse(originalSql);  
        }  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @return_type void 
     * 
     */  
    protected abstract void initializeSegments();  
  
    /** 
     * 得到解析完毕的Sql语句 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @return 
     * @return_type String 
     * 
     */  
    public String getParsedSql() {  
        StringBuffer stringBuffer = new StringBuffer();  
        for (SqlSegment sqlSegment : segments) {  
            stringBuffer.append(sqlSegment.getParsedSqlSegment());  
        }  
        String result = stringBuffer.toString().replaceAll("@+", "\n");  
        return result;  
    }  
  
    /** 
     * 得到解析的sql片段 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @return 
     * @return_type List<SqlSegment> 
     * 
     */  
    public List<SqlSegment> returnSqlSegments() {  
        int segmentLength = this.segments.size();  
        if (segmentLength != 0) {  
            List<SqlSegment> result = this.segments;  
            return result;  
        }  
        return null;  
    }  
}  
