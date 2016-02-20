package com.tt.exam.exam_part.choice.bean;

import com.tt.exam.exam_part.base.ExamBase;

public class Choice extends ExamBase {
	private String options;

	public Choice() {
		// do nothing
	}

	public Choice(String id, String exam_id, String content, String options, String answer, String analysis,
			String description, String remark) {
		super(id, exam_id, content, answer, analysis, description, remark);
		this.options = options;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
