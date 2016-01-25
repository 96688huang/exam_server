package com.tt.exam.examinee.service;

import java.util.List;

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

	public void update(Examinee examinee) {
		examineeDao.update(examinee);
	}

	public List<Examinee> list() {
		return examineeDao.list();
	}

	public Examinee findBy(String id) {
		return examineeDao.findBy(id);
	}

	public void deleteBy(String id) {
		examineeDao.delete(id);
	}
}
