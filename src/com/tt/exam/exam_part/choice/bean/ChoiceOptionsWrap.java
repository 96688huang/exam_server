package com.tt.exam.exam_part.choice.bean;

import java.util.List;

public class ChoiceOptionsWrap {
	private List<ChoiceOption> choiceOptions;

	public ChoiceOptionsWrap() {
		// do nothing
	}

	public ChoiceOptionsWrap(List<ChoiceOption> choiceOptions) {
		this.choiceOptions = choiceOptions;
	}

	public List<ChoiceOption> getChoiceOptions() {
		return choiceOptions;
	}

	public void setChoiceOptions(List<ChoiceOption> choiceOptions) {
		this.choiceOptions = choiceOptions;
	}

}
