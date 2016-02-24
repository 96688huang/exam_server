package com.tt.exam.exam_part.essay.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.exam_part.essay.bean.Essay;
import com.tt.exam.exam_part.essay.persistent.EssayDao;

@Service
public class EssayService {

	@Resource
	private EssayDao essayDao;

	public int add(Essay essay) {
		return essayDao.add(essay);
	}

	public int update(Essay essay) {
		return essayDao.update(essay);
	}

	public List<Essay> list(String exam_id) {
		return essayDao.list(exam_id);
	}

	public Essay findBy(String id) {
		return essayDao.findBy(id);
	}

	public int deleteBy(String id) {
		return essayDao.delete(id);
	}
}
