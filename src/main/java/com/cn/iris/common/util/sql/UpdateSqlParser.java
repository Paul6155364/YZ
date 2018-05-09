package com.cn.iris.common.util.sql;

/** 
 * 单句更新sql语句 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class UpdateSqlParser extends BaseSingleSqlParser {  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @param originalSql 
     */  
    public UpdateSqlParser(String originalSql) {  
  
        super(originalSql);  
  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @see com.hz.util.sql.BaseSingleSqlParser#initializeSegments() 
     */  
    @Override  
    protected void initializeSegments() {  
        segments.add(new SqlSegment("(update)(.+)(set)", "[,]"));  
        segments.add(new SqlSegment("(set)(.+)( where | ENDOFSQL)", "[,]"));  
        segments.add(new SqlSegment("(where)(.+)( ENDOFSQL)", "(and|or)"));  
    }  
  
}  
