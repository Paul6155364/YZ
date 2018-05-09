package com.cn.iris.common.util.sql;

import java.util.List;  

/** 
 * 单句sql解析器制造工厂 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class SqlParserUtil {  
  
    /** 
     * 方法的主要入口 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @param sql 
     *            要解析的sql语句 
     * @return 返回解析结果 
     * @return_type String 
     * 
     */  
    public String getParsedSql(String sql) {  
        sql = sql.trim();  
        sql = sql.toLowerCase();  
        sql = sql.replace("\\s{1,}", " ");  
        sql = "" + sql + " ENDOFSQL";  
        return SingleSqlParserFactory.generateParser(sql).getParsedSql();  
    }  
  
    /** 
     * SQL语句解析的接口 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @param sql 
     *            要解析的sql语句 
     * @return 返回解析结果 
     * @return_type List<SqlSegment> 
     * 
     */  
    public List<SqlSegment> getParsedSqlList(String sql) {  
        sql = sql.trim();  
        sql = sql.trim();  
        sql = sql.toLowerCase();  
        sql = sql.replace("\\s{1,}", " ");  
        sql = "" + sql + " ENDOFSQL";  
        return SingleSqlParserFactory.generateParser(sql).returnSqlSegments();  
    }  
  
}
