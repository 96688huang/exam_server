package com.tt.exam.exam_part.multi_choice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.exam.exam_part.multi_choice.bean.MultiChoice;
import com.tt.exam.exam_part.multi_choice.persistent.MultiChoiceDao;

@Service
public class MultiChoiceService {

	@Resource
	private MultiChoiceDao multiChoiceDao;

	public int add(MultiChoice multiChoice) {
		return multiChoiceDao.add(multiChoice);
	}

	public int update(MultiChoice multiChoice) {
		return multiChoiceDao.update(multiChoice);
	}

	public List<MultiChoice> list(String exam_id) {
		return multiChoiceDao.list(exam_id);
	}

	public MultiChoice findBy(String id) {
		return multiChoiceDao.findBy(id);
	}

	public int deleteBy(String id) {
		return multiChoiceDao.delete(id);
	}
}
