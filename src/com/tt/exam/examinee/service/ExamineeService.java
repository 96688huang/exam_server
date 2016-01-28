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

	public int register(Examinee examinee) {
		return examineeDao.add(examinee);
	}

	public int update(Examinee examinee) {
		return examineeDao.update(examinee);
	}

	public List<Examinee> list() {
		return examineeDao.list();
	}

	public Examinee findBy(String id) {
		return examineeDao.findBy(id);
	}

	public int deleteBy(String id) {
		return examineeDao.delete(id);
	}

	public Examinee findBy(String account, String pwdMd5) {
		return examineeDao.findBy(account, pwdMd5);
	}
}
