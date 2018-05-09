package com.cn.iris.submission.mapper;

import java.util.List;

import com.cn.iris.submission.entity.Datasource;

public interface DatasourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Datasource record);

    int insertSelective(Datasource record);

    Datasource selectByPrimaryKey(String id);
    
    List<Datasource> loadSelect();
    
    Datasource dbchose(String db);
    
    Datasource doquery(String db);

    int updateByPrimaryKeySelective(Datasource record);

    int updateByPrimaryKey(Datasource record);
}