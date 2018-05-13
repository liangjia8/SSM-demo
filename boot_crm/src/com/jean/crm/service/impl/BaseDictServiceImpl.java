package com.jean.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.crm.dao.BaseDictDao;
import com.jean.crm.pojo.BaseDict;
import com.jean.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService{
	
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getDictListByTypeCode(String typeCode) {
		
		return baseDictDao.getDictListByTypeCode(typeCode);
	}

}
