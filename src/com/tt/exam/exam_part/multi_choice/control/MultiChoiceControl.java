package com.tt.exam.exam_part.multi_choice.control;

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
import com.tt.exam.exam_part.multi_choice.bean.MultiChoice;
import com.tt.exam.exam_part.multi_choice.bean.MultiChoiceOption;
import com.tt.exam.exam_part.multi_choice.bean.MultiChoiceOptionsWrap;
import com.tt.exam.exam_part.multi_choice.service.MultiChoiceService;

@Controller
public class MultiChoiceControl {
	private final Logger logger = LoggerFactory.getLogger(MultiChoiceControl.class);

	@Resource
	private MultiChoiceService multiChoiceService;

	/**
	 * NOTE: 选项列表参数传递，可以采用json字符串或类包装的方式。采用类包装方式时，无需 @RequestParam 注解修饰。
	 */
	@RequestMapping("multiChoice!add.do")
	public ModelAndView add(@RequestParam String exam_id, @RequestParam String content, @RequestParam String analysis,
			@RequestParam String description, MultiChoiceOptionsWrap multiChoiceOptionsWrap) {
		logger.info("add...exam_id: {}, content: {}, option: {}, analysis: {}, remark: {}", exam_id, content,
				multiChoiceOptionsWrap.getMultiChoiceOptionList(), analysis, description);

		String optionJson = JSONObject.toJSONString(multiChoiceOptionsWrap.getMultiChoiceOptionList());
		List<MultiChoiceOption> answerOptionList = FluentIterable
				.from(multiChoiceOptionsWrap.getMultiChoiceOptionList()).filter(new Predicate<MultiChoiceOption>() {
					@Override
					public boolean apply(MultiChoiceOption option) {
						return option.getIsAnswer().equals(ExamConstant.Y);
					}
				}).toList();
		// TODO 未进行合法性校验
		StringBuilder answerBuf = new StringBuilder();
		for (MultiChoiceOption option : answerOptionList) {
			answerBuf.append(option.getTab()).append(",");
		}
		String answer = answerBuf.toString().substring(0, answerBuf.length() - 1);

		String id = UuidUtil.genereateId();
		MultiChoice multiChoice = new MultiChoice(id, exam_id, content, optionJson, answer, analysis, description, "");
		int addRows = multiChoiceService.add(multiChoice);

		ModelAndView mv = new ModelAndView("/exam_part/multi_choice/update");
		mv.addObject("multiChoice", multiChoice);
		mv.addObject("message", addRows > 0 ? "添加成功" : "添加失败");
		return mv;
	}

	@RequestMapping("multiChoice!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String exam_id, @RequestParam String content,
			@RequestParam String answer, @RequestParam String analysis, @RequestParam String remark) {
		logger.info("update...exam_id: {}, content: {}, answer: {}, analysis: {}, remark: {}", exam_id, content,
				answer, analysis, remark);
		MultiChoice multiChoice = new MultiChoice(id, exam_id, content, "", answer, analysis, "", remark);
		int uptRows = multiChoiceService.update(multiChoice);

		ModelAndView mv = new ModelAndView("/exam_part/multi_choice/update");
		mv.addObject("multiChoice", multiChoice);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("multiChoice!list.do")
	public ModelAndView list(@RequestParam String exam_id) {
		List<MultiChoice> list = multiChoiceService.list(exam_id);
		ModelAndView mv = new ModelAndView("/exam_part/multi_choice/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("multiChoice!find.do")
	public ModelAndView find(@RequestParam String id) {
		MultiChoice multiChoice = multiChoiceService.findBy(id);
		ModelAndView mv = new ModelAndView("/exam_part/multi_choice/update");
		mv.addObject("multiChoice", multiChoice);
		mv.addObject("message", "multiChoice 信息");
		return mv;
	}

	@RequestMapping("multiChoice!delete.do")
	public ModelAndView delete(@RequestParam String id, @RequestParam String exam_id) {
		multiChoiceService.deleteBy(id);
		return list(exam_id);
	}
}
