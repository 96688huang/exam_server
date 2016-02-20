package com.tt.exam.exam_part.base;

public abstract class ExamBase {
	private String id;
	private String exam_id;
	private String content;
	private String answer;
	private String analysis;
	private String description;
	private String remark;

	public ExamBase() {
		// do nothing
	}

	public ExamBase(String id, String exam_id, String content, String answer, String analysis, String description,
			String remark) {
		this.id = id;
		this.exam_id = exam_id;
		this.content = content;
		this.answer = answer;
		this.analysis = analysis;
		this.description = description;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExam_id() {
		return exam_id;
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
