package com.tt.exam.exam_part.essay.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.exam_part.essay.bean.Essay;
import com.tt.exam.exam_part.essay.service.EssayService;

@Controller
public class EssayControl {
	private final Logger logger = LoggerFactory.getLogger(EssayControl.class);

	@Resource
	private EssayService essayService;

	@RequestMapping("essay!add.do")
	public ModelAndView add(@RequestParam String exam_id, @RequestParam String content, @RequestParam String answer,
			@RequestParam String analysis, @RequestParam String description) {
		logger.info("add...exam_id: {}, content: {}, answer: {}, analysis: {}, remark: {}", exam_id, content, answer,
				analysis, description);

		String id = UuidUtil.genereateId();
		Essay essay = new Essay(id, exam_id, content, answer, analysis, description, "");
		int addRows = essayService.add(essay);

		ModelAndView mv = new ModelAndView("/exam_part/essay/update");
		mv.addObject("essay", essay);
		mv.addObject("message", addRows > 0 ? "添加成功" : "添加失败");
		return mv;
	}

	@RequestMapping("essay!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String exam_id, @RequestParam String content,
			@RequestParam String answer, @RequestParam String analysis, @RequestParam String description) {
		logger.info("update...exam_id: {}, content: {}, answer: {}, analysis: {}, description: {}", exam_id, content,
				answer, analysis, description);
		Essay essay = new Essay(id, exam_id, content, answer, analysis, description, "");
		int uptRows = essayService.update(essay);

		ModelAndView mv = new ModelAndView("/exam_part/essay/update");
		mv.addObject("essay", essay);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("essay!list.do")
	public ModelAndView list(@RequestParam String exam_id) {
		List<Essay> list = essayService.list(exam_id);
		ModelAndView mv = new ModelAndView("/exam_part/essay/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("essay!find.do")
	public ModelAndView find(@RequestParam String id) {
		Essay essay = essayService.findBy(id);
		ModelAndView mv = new ModelAndView("/exam_part/essay/update");
		mv.addObject("essay", essay);
		mv.addObject("message", "essay 信息");
		return mv;
	}

	@RequestMapping("essay!delete.do")
	public ModelAndView delete(@RequestParam String id, @RequestParam String exam_id) {
		essayService.deleteBy(id);
		return list(exam_id);
	}
}
