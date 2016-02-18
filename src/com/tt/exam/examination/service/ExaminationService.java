package com.tt.exam.examination.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.examination.bean.Examination;
import com.tt.exam.examination.persistent.ExaminationDao;

@Service
public class ExaminationService {

	@Resource
	private ExaminationDao examinationDao;

	public int add(Examination examination) {
		return examinationDao.add(examination);
	}

	public int update(Examination examination) {
		return examinationDao.update(examination);
	}

	public List<Examination> list(String category_id) {
		return examinationDao.list(category_id);
	}

	public Examination findBy(String id) {
		return examinationDao.findBy(id);
	}

	public int deleteBy(String id) {
		return examinationDao.delete(id);
	}
}
