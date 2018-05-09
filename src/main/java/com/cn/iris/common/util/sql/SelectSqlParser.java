package com.cn.iris.common.util.sql;

/** 
 * 单句查询语句解析器 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class SelectSqlParser extends BaseSingleSqlParser {  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @param originalSql 
     */  
    public SelectSqlParser(String originalSql) {  
  
        super(originalSql);  
  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @see com.hz.util.sql.BaseSingleSqlParser#initializeSegments() 
     */  
    @Override  
    protected void initializeSegments() {  
        segments.add(new SqlSegment("(select)(.+)(from)", "[,]"));  
        segments.add(new SqlSegment("(from)(.+)( where | on | having | group by | order by | ENDOFSQL)",  
                "(,| left join | right join | inner join )"));  
        segments.add(new SqlSegment("(where|on|having)(.+)( group by | order by | ENDOFSQL)", "(and|or)"));  
        segments.add(new SqlSegment("(group by)(.+)( order by| ENDOFSQL)", "[,]"));  
        segments.add(new SqlSegment("(order by)(.+)( ENDOFSQL)", "[,]"));  
    }  
  
}  
