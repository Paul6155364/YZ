package com.cn.iris.submission.service;

import java.util.List;

import com.cn.iris.submission.entity.Datasource;

public interface IDatasourceService {
	/**
	 * 
	 * @return
	 */
	public List<Datasource> loadSelect();
	/**
	 * 
	 * @return
	 */
	public Datasource dbchose(String db);
	/**
	 * ss
	 * @param db
	 * @return
	 */
	public Datasource doquery(String db);
}
