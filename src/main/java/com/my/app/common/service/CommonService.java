package com.my.app.common.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.common.dao.CommonDao;

@Service
public class CommonService {

	@Autowired
	private CommonDao commonDao;

	public Timestamp getCurrentTimestamp() {
		return commonDao.selectOne("Common.selectCurrentTimestamp", null);
	}

}
