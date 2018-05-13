package com.jean.crm.service;

import java.util.List;

import com.jean.crm.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> getDictListByTypeCode(String typeCode);
}
