package com.tt.exam.exam_part.judge.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.exam_part.judge.bean.Judge;
import com.tt.exam.exam_part.judge.persistent.JudgeDao;

@Service
public class JudgeService {

	@Resource
	private JudgeDao judgeDao;

	public int add(Judge judge) {
		return judgeDao.add(judge);
	}

	public int update(Judge judge) {
		return judgeDao.update(judge);
	}

	public List<Judge> list(String exam_id) {
		return judgeDao.list(exam_id);
	}

	public Judge findBy(String id) {
		return judgeDao.findBy(id);
	}

	public int deleteBy(String id) {
		return judgeDao.delete(id);
	}
}
