package com.tt.exam.exam_category.bean;

public class ExamCategory {

	private String id;
	private String owner_id;
	private String name;
	private String description;
	private String remark;

	public ExamCategory() {
		// do nothing
	}

	public ExamCategory(String id, String owner_id, String name, String description) {
		this.id = id;
		this.owner_id = owner_id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
