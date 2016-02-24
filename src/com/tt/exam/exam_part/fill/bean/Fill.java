package com.tt.exam.exam_part.fill.bean;

import com.tt.exam.exam_part.base.ExamBase;

public class Fill extends ExamBase {

	public Fill() {
		// do nothing
	}

	public Fill(String id, String exam_id, String content, String answer, String analysis, String description,
			String remark) {
		super(id, exam_id, content, answer, analysis, description, remark);
	}
}
