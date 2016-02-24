package com.tt.exam.exam_part.judge.bean;

import com.tt.exam.exam_part.base.ExamBase;

public class Judge extends ExamBase {

	public Judge() {
		// do nothing
	}

	public Judge(String id, String exam_id, String content, String answer, String analysis, String description,
			String remark) {
		super(id, exam_id, content, answer, analysis, description, remark);
	}
}
