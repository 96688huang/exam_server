package com.tt.exam.exam_part.judge.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.exam_part.judge.bean.Judge;
import com.tt.exam.exam_part.judge.service.JudgeService;

@Controller
public class JudgeControl {
	private final Logger logger = LoggerFactory.getLogger(JudgeControl.class);

	@Resource
	private JudgeService judgeService;

	@RequestMapping("judge!add.do")
	public ModelAndView add(@RequestParam String exam_id, @RequestParam String content, @RequestParam String answer,
			@RequestParam String analysis, @RequestParam String description) {
		logger.info("add...exam_id: {}, content: {}, answer: {}, analysis: {}, remark: {}", exam_id, content, answer,
				analysis, description);

		String id = UuidUtil.genereateId();
		Judge judge = new Judge(id, exam_id, content, answer, analysis, description, "");
		int addRows = judgeService.add(judge);

		ModelAndView mv = new ModelAndView("/exam_part/judge/update");
		mv.addObject("judge", judge);
		mv.addObject("message", addRows > 0 ? "添加成功" : "添加失败");
		return mv;
	}

	@RequestMapping("judge!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String exam_id, @RequestParam String content,
			@RequestParam String answer, @RequestParam String analysis, @RequestParam String remark) {
		logger.info("update...exam_id: {}, content: {}, answer: {}, analysis: {}, remark: {}", exam_id, content,
				answer, analysis, remark);
		Judge judge = new Judge(id, exam_id, content, answer, analysis, "", remark);
		int uptRows = judgeService.update(judge);

		ModelAndView mv = new ModelAndView("/exam_part/judge/update");
		mv.addObject("judge", judge);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("judge!list.do")
	public ModelAndView list(@RequestParam String exam_id) {
		List<Judge> list = judgeService.list(exam_id);
		ModelAndView mv = new ModelAndView("/exam_part/judge/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("judge!find.do")
	public ModelAndView find(@RequestParam String id) {
		Judge judge = judgeService.findBy(id);
		ModelAndView mv = new ModelAndView("/exam_part/judge/update");
		mv.addObject("judge", judge);
		mv.addObject("message", "judge 信息");
		return mv;
	}

	@RequestMapping("judge!delete.do")
	public ModelAndView delete(@RequestParam String id, @RequestParam String exam_id) {
		judgeService.deleteBy(id);
		return list(exam_id);
	}
}
