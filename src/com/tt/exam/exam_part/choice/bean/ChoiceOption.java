package com.tt.exam.exam_part.choice.bean;

public class ChoiceOption {
	private String tab;
	private String content;
	private String isAnswer; // Y or N

	public ChoiceOption() {
		// do nothing
	}

	public ChoiceOption(String tab, String content, String isAnswer) {
		this.tab = tab;
		this.content = content;
		this.isAnswer = isAnswer;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(String isAnswer) {
		this.isAnswer = isAnswer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChoiceOption [tab=");
		builder.append(tab);
		builder.append(", content=");
		builder.append(content);
		builder.append(", isAnswer=");
		builder.append(isAnswer);
		builder.append("]");
		return builder.toString();
	}

}
