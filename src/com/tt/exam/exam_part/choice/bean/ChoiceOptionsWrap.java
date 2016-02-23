package com.tt.exam.exam_part.choice.bean;

import java.util.List;

public class ChoiceOptionsWrap {
	private List<ChoiceOption> choiceOptionList;

	public ChoiceOptionsWrap() {
		// do nothing
	}

	public ChoiceOptionsWrap(List<ChoiceOption> choiceOptions) {
		this.choiceOptionList = choiceOptions;
	}

	public List<ChoiceOption> getChoiceOptionList() {
		return choiceOptionList;
	}

	public void setChoiceOptionList(List<ChoiceOption> choiceOptionList) {
		this.choiceOptionList = choiceOptionList;
	}

}
