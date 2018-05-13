package com.jean.crm.dao;

import java.util.List;

import com.jean.crm.pojo.BaseDict;

public interface BaseDictDao {

	public List<BaseDict> getDictListByTypeCode(String typeCode);
}
