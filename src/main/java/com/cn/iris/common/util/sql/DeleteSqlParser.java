package com.cn.iris.common.util.sql;

/** 
 * 单句删除语句解析 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class DeleteSqlParser extends BaseSingleSqlParser {  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @param originalSql 
     */  
    public DeleteSqlParser(String originalSql) {  
  
        super(originalSql);  
  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @see com.cn.iris.common.util.sql.hz.util.sql.BaseSingleSqlParser#initializeSegments() 
     */  
    @Override  
    protected void initializeSegments() {  
        segments.add(new SqlSegment("(delete from)(.+)(where | ENDOFSQL)", "[,]"));  
        segments.add(new SqlSegment("(where)(.+)( ENDOFSQL)", "(and|or)"));  
    }  
  
}  


