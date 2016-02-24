package com.tt.exam.exam_part.fill.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.exam_part.fill.bean.Fill;
import com.tt.exam.exam_part.fill.persistent.FillDao;

@Service
public class FillService {

	@Resource
	private FillDao fillDao;

	public int add(Fill fill) {
		return fillDao.add(fill);
	}

	public int update(Fill fill) {
		return fillDao.update(fill);
	}

	public List<Fill> list(String exam_id) {
		return fillDao.list(exam_id);
	}

	public Fill findBy(String id) {
		return fillDao.findBy(id);
	}

	public int deleteBy(String id) {
		return fillDao.delete(id);
	}
}
