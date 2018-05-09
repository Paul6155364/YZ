package com.cn.iris.common.util.sql;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
/** 
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class SingleSqlParserFactory {  
  
    public static BaseSingleSqlParser generateParser(String sql) {  
        if (contains(sql, "(insert into)(.+)(select)(.+)(from)(.+)")) {  
            return new InsertSelectSqlParser(sql);  
        } else if (contains(sql, "(select)(.+)(from)(.+)")) {  
            return new SelectSqlParser(sql);  
        } else if (contains(sql, "(delete from)(.+)")) {  
            return new DeleteSqlParser(sql);  
        } else if (contains(sql, "(update)(.+)(set)(.+)")) {  
            return new UpdateSqlParser(sql);  
        } else if (contains(sql, "(insert into)(.+)(values)(.+)")) {  
            return new InsertSqlParser(sql);  
        }  
  
        return new InsertSqlParser(sql);  
    }  
  
    /** 
     * 看word是否在lineText中存在，支持正则表达式 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @param sql 
     * @param regExp 
     * @return 
     * @return_type boolean 
     * 
     */  
    private static boolean contains(String sql, String regExp) {  
        Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);  
        Matcher matcher = pattern.matcher(sql);  
        return matcher.find();  
    }  
  
}  
