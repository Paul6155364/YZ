package com.cn.iris.common.util.sql;

/** 
 * 单句查询插入语句解析器 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class InsertSelectSqlParser extends BaseSingleSqlParser {  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @param originalSql 
     */  
    public InsertSelectSqlParser(String originalSql) {  
  
        super(originalSql);  
  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @see com.hz.util.sql.BaseSingleSqlParser#initializeSegments() 
     */  
    @Override  
    protected void initializeSegments() {  
        segments.add(new SqlSegment("(insert into)(.+)( select )", "[,]"));  
        segments.add(new SqlSegment("(select)(.+)(from)", "[,]"));  
        segments.add(new SqlSegment("(from)(.+)( where | on | having | groups+by | orders+by | ENDOFSQL)",  
                "(,|s+lefts+joins+|s+rights+joins+|s+inners+joins+)"));  
        segments.add(new SqlSegment("(where|on|having)(.+)( groups+by | orders+by | ENDOFSQL)", "(and|or)"));  
        segments.add(new SqlSegment("(groups+by)(.+)( orders+by| ENDOFSQL)", "[,]"));  
        segments.add(new SqlSegment("(orders+by)(.+)( ENDOFSQL)", "[,]"));  
    }  
  
}  
