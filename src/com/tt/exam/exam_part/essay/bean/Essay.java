package com.tt.exam.exam_part.essay.bean;

import com.tt.exam.exam_part.base.ExamBase;

public class Essay extends ExamBase {

	public Essay() {
		// do nothing
	}

	public Essay(String id, String exam_id, String content, String answer, String analysis, String description,
			String remark) {
		super(id, exam_id, content, answer, analysis, description, remark);
	}
}
