package com.tt.exam.examination.bean;

public class Examination {

	private String id;
	private String category_id;
	private String name;
	private String description;
	private String remark;

	public Examination() {
		// do nothing
	}

	public Examination(String id, String category_id, String name, String description) {
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
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
