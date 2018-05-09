package com.cn.iris.common.util.sql;

/** 
 * 单句插入语句解析 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class InsertSqlParser extends BaseSingleSqlParser {  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @param originalSql 
     */  
    public InsertSqlParser(String originalSql) {  
  
        super(originalSql);  
  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @see com.hz.util.sql.BaseSingleSqlParser#initializeSegments() 
     */  
    @Override  
    protected void initializeSegments() {  
        segments.add(new SqlSegment("(insert into)(.+)([(])", "[,]"));  
        segments.add(new SqlSegment("([(])(.+)( [)] values )", "[,]"));  
        segments.add(new SqlSegment("([)] values [(])(.+)( [)])", "[,]"));  
    }  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     * @return 
     * @see com.hz.util.sql.BaseSingleSqlParser#getParsedSql() 
     */  
    @Override  
    public String getParsedSql() {  
  
        String result = super.getParsedSql();  
        result += ")";  
  
        return result;  
    }  
  
}  
