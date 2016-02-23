package com.tt.exam.exam_part.multi_choice.bean;

import java.util.List;

public class MultiChoiceOptionsWrap {
	private List<MultiChoiceOption> multiChoiceOptionList;

	public MultiChoiceOptionsWrap() {
		// do nothing
	}

	public MultiChoiceOptionsWrap(List<MultiChoiceOption> multiChoiceOptionList) {
		this.multiChoiceOptionList = multiChoiceOptionList;
	}

	public List<MultiChoiceOption> getMultiChoiceOptionList() {
		return multiChoiceOptionList;
	}

	public void setMultiChoiceOptionList(List<MultiChoiceOption> multiChoiceOptionList) {
		this.multiChoiceOptionList = multiChoiceOptionList;
	}

}
