package com.tt.exam.exam_category.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.exam_category.bean.ExamCategory;
import com.tt.exam.exam_category.persistent.ExamCategoryDao;

@Service
public class ExamCategoryService {

	@Resource
	private ExamCategoryDao examCategoryDao;

	public int add(ExamCategory examCategory) {
		return examCategoryDao.add(examCategory);
	}

	public int update(ExamCategory examCategory) {
		return examCategoryDao.update(examCategory);
	}

	public List<ExamCategory> list(ExamCategory examCategory) {
		return examCategoryDao.list(examCategory);
	}

	public int deleteBy(String id, String ownerId) {
		return examCategoryDao.delete(id, ownerId);
	}
}
