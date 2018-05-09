package com.cn.iris.submission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.iris.submission.entity.Datasource;
import com.cn.iris.submission.mapper.DatasourceMapper;
import com.cn.iris.submission.service.IDatasourceService;
@Service
public class DatasourceServiceImpl implements IDatasourceService {
	
	@Autowired
	public DatasourceMapper datasourceMapper;

	@Override
	public List<Datasource> loadSelect() {
		// TODO Auto-generated method stub
		return datasourceMapper.loadSelect();
	}

	@Override
	public Datasource dbchose(String db) {
		// TODO Auto-generated method stub
		return datasourceMapper.dbchose(db);
	}
	@Override
	public Datasource doquery(String db) {
		// TODO Auto-generated method stub
		return datasourceMapper.doquery(db);
	}

}
