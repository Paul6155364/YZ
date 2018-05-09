package com.cn.iris.submission.entity;

import java.io.Serializable;

/**
 * datasource
 * @author 
 */
public class Datasource implements Serializable {
    private String id;

    /**
     * 数据源
     */
    private String dataSource;

    /**
     * 数据库名称
     */
    private String dbname;

    /**
     * 驱动
     */
    private String drive;

    /**
     * 链接
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}