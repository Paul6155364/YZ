package com.cn.iris.common.util.sql;

import java.util.ArrayList;  
import java.util.List;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
/** 
 * sql语句片段 
 *  
 * @author yxh 
 * @time 2018年5月8日 
 */  
public class SqlSegment {  
    private static final String Crlf = "@";  
    private static final String FourSpace = "　　";  
    // sql语句片段开头  
    private String start;  
    // sql语句片段中间部分  
    private String body;  
    // sql语句片段结束部分  
    private String end;  
    // 表示片段的正则表达式  
    private String segmentRegExp;  
    // 分割后的body小片段  
    private List<String> bodyPieces;  
    // 用于分割中间部分的正则表达式  
    private String bodySplitPattern;  
  
    /** 
     * @author yxh 
     * @time 2018年5月8日 
     */  
    public SqlSegment(String segmentRegExp, String bodySplitPattern) {  
        start = "";  
        body = "";  
        end = "";  
        this.segmentRegExp = segmentRegExp;  
        this.bodySplitPattern = bodySplitPattern;  
        this.bodyPieces = new ArrayList<>();  
    }  
  
    /** 
     * 从sql中查找符合segmentRegExp的部分,并赋值到start,body,end三个属性中 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @param sql 
     * @return_type void 
     * 
     */  
    public void parse(String sql) {  
        Pattern pattern = Pattern.compile(segmentRegExp, Pattern.CASE_INSENSITIVE);  
        for (int i = 0; i <= sql.length(); i++) {  
            String shortSql = sql.substring(0, i);  
            // 测试输出的子句是否正确 System.out.println(shortSql);  
            Matcher matcher = pattern.matcher(shortSql);  
            while (matcher.find()) {  
                start = matcher.group(1);  
                body = matcher.group(2);  
                end = matcher.group(3);  
                return;  
            }  
        }  
    }  
  
    /** 
     * 解析body片段 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @return_type void 
     * 
     */  
    @SuppressWarnings("unused")  
    private void parseBody() {  
  
        List<String> ls = new ArrayList<String>();  
        Pattern p = Pattern.compile(bodySplitPattern, Pattern.CASE_INSENSITIVE);  
        // 先清除掉前后空格  
        body = body.trim();  
        Matcher m = p.matcher(body);  
        StringBuffer sb = new StringBuffer();  
        boolean result = m.find();  
        while (result) {  
            m.appendReplacement(sb, m.group(0) + Crlf);  
            result = m.find();  
        }  
        m.appendTail(sb);  
        // 再按空格断行  
        String[] arr = sb.toString().split(" ");  
        int arrLength = arr.length;  
        for (int i = 0; i < arrLength; i++) {  
            String temp = FourSpace + arr[i];  
            if (i != arrLength - 1) {  
                // temp=temp+Crlf; }  
                ls.add(temp);  
            }  
            bodyPieces = ls;  
        }  
    }  
  
    /** 
     * 取得解析好的sql片段 
     *  
     * @author yxh 
     * @time 2018年5月8日 
     * @return 
     * @return_type String 
     * 
     */  
    public String getParsedSqlSegment() {  
        StringBuffer sb = new StringBuffer();  
        sb.append(start + Crlf);  
        for (String piece : bodyPieces) {  
            sb.append(piece + Crlf);  
        }  
        return sb.toString();  
    }  
  
    /** 
     * @return the start 
     */  
    public String getStart() {  
        return start;  
    }  
  
    /** 
     * @param start 
     *            the start to set 
     */  
    public void setStart(String start) {  
        this.start = start;  
    }  
  
    /** 
     * @return the body 
     */  
    public String getBody() {  
        return body;  
    }  
  
    /** 
     * @param body 
     *            the body to set 
     */  
    public void setBody(String body) {  
        this.body = body;  
    }  
  
    /** 
     * @return the end 
     */  
    public String getEnd() {  
        return end;  
    }  
  
    /** 
     * @param end 
     *            the end to set 
     */  
    public void setEnd(String end) {  
        this.end = end;  
    }  
  
    /** 
     * @return the segmentRegExp 
     */  
    public String getSegmentRegExp() {  
        return segmentRegExp;  
    }  
  
    /** 
     * @param segmentRegExp 
     *            the segmentRegExp to set 
     */  
    public void setSegmentRegExp(String segmentRegExp) {  
        this.segmentRegExp = segmentRegExp;  
    }  
  
    /** 
     * @return the bodyPieces 
     */  
    public List<String> getBodyPieces() {  
        return bodyPieces;  
    }  
  
    /** 
     * @param bodyPieces 
     *            the bodyPieces to set 
     */  
    public void setBodyPieces(List<String> bodyPieces) {  
        this.bodyPieces = bodyPieces;  
    }  
  
    /** 
     * @return the bodySplitPattern 
     */  
    public String getBodySplitPattern() {  
        return bodySplitPattern;  
    }  
  
    /** 
     * @param bodySplitPattern 
     *            the bodySplitPattern to set 
     */  
    public void setBodySplitPattern(String bodySplitPattern) {  
        this.bodySplitPattern = bodySplitPattern;  
    }  
  
}  
