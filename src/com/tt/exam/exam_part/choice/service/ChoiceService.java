package com.tt.exam.exam_part.choice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.exam_part.choice.bean.Choice;
import com.tt.exam.exam_part.choice.persistent.ChoiceDao;

@Service
public class ChoiceService {

	@Resource
	private ChoiceDao choiceDao;

	public int add(Choice choice) {
		return choiceDao.add(choice);
	}

	public int update(Choice choice) {
		return choiceDao.update(choice);
	}

	public List<Choice> list(String exam_id) {
		return choiceDao.list(exam_id);
	}

	public Choice findBy(String id) {
		return choiceDao.findBy(id);
	}

	public int deleteBy(String id) {
		return choiceDao.delete(id);
	}
}
