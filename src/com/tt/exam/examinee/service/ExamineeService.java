package com.tt.exam.examinee.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.examinee.bean.Examinee;
import com.tt.exam.examinee.persistent.ExamineeDao;

@Service
public class ExamineeService {

	@Resource
	private ExamineeDao examineeDao;

	public void register(Examinee examinee) {
		examineeDao.add(examinee);
	}
}
