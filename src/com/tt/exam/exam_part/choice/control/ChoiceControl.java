package com.tt.exam.exam_part.choice.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.tt.exam.common.constant.ExamConstant;
import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.exam_part.choice.bean.Choice;
import com.tt.exam.exam_part.choice.bean.ChoiceOption;
import com.tt.exam.exam_part.choice.bean.ChoiceOptionsWrap;
import com.tt.exam.exam_part.choice.service.ChoiceService;

@Controller
public class ChoiceControl {
	private final Logger logger = LoggerFactory.getLogger(ChoiceControl.class);

	@Resource
	private ChoiceService choiceService;

	/**
	 * NOTE: 选项列表参数传递，可以采用json字符串或类包装的方式。采用类包装方式时，无需 @RequestParam 注解修饰。
	 */
	@RequestMapping("choice!add.do")
	public ModelAndView add(@RequestParam String exam_id, @RequestParam String content, @RequestParam String analysis,
			@RequestParam String description, ChoiceOptionsWrap choiceOptionsWrap) {
		logger.info("add...exam_id: {}, content: {}, option: {}, analysis: {}, remark: {}", exam_id, content,
				choiceOptionsWrap.getChoiceOptionList(), analysis, description);

		String optionJson = JSONObject.toJSONString(choiceOptionsWrap.getChoiceOptionList());
		List<ChoiceOption> answerOptionList = FluentIterable.from(choiceOptionsWrap.getChoiceOptionList())
				.filter(new Predicate<ChoiceOption>() {
					@Override
					public boolean apply(ChoiceOption option) {
						return option.getIsAnswer().equals(ExamConstant.Y);
					}
				}).toList();
		// TODO 未进行合法性校验
		String answer = answerOptionList.get(0).getTab();
		String id = UuidUtil.genereateId();
		Choice choice = new Choice(id, exam_id, content, optionJson, answer, analysis, description, "");
		int addRows = choiceService.add(choice);

		ModelAndView mv = new ModelAndView("/exam_part/choice/update");
		mv.addObject("choice", choice);
		mv.addObject("message", addRows > 0 ? "添加成功" : "添加失败");
		return mv;
	}

	@RequestMapping("choice!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String exam_id, @RequestParam String content,
			@RequestParam String answer, @RequestParam String analysis, @RequestParam String remark) {
		logger.info("update...exam_id: {}, content: {}, answer: {}, analysis: {}, remark: {}", exam_id, content,
				answer, analysis, remark);
		Choice choice = new Choice(id, exam_id, content, "", answer, analysis, "", remark);
		int uptRows = choiceService.update(choice);

		ModelAndView mv = new ModelAndView("/exam_part/choice/update");
		mv.addObject("choice", choice);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("choice!list.do")
	public ModelAndView list(@RequestParam String exam_id) {
		List<Choice> list = choiceService.list(exam_id);
		ModelAndView mv = new ModelAndView("/exam_part/choice/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("choice!find.do")
	public ModelAndView find(@RequestParam String id) {
		Choice choice = choiceService.findBy(id);
		ModelAndView mv = new ModelAndView("/exam_part/choice/update");
		mv.addObject("choice", choice);
		mv.addObject("message", "choice 信息");
		return mv;
	}

	@RequestMapping("choice!delete.do")
	public ModelAndView delete(@RequestParam String id, @RequestParam String exam_id) {
		choiceService.deleteBy(id);
		return list(exam_id);
	}
}
