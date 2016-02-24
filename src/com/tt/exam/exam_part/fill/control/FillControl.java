package com.tt.exam.exam_part.fill.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.exam_part.fill.bean.Fill;
import com.tt.exam.exam_part.fill.service.FillService;

@Controller
public class FillControl {
	private final Logger logger = LoggerFactory.getLogger(FillControl.class);

	@Resource
	private FillService fillService;

	@RequestMapping("fill!add.do")
	public ModelAndView add(@RequestParam String exam_id, @RequestParam String content, @RequestParam String answer,
			@RequestParam String analysis, @RequestParam String description) {
		logger.info("add...exam_id: {}, content: {}, answer: {}, analysis: {}, remark: {}", exam_id, content, answer,
				analysis, description);

		String id = UuidUtil.genereateId();
		Fill fill = new Fill(id, exam_id, content, answer, analysis, description, "");
		int addRows = fillService.add(fill);

		ModelAndView mv = new ModelAndView("/exam_part/fill/update");
		mv.addObject("fill", fill);
		mv.addObject("message", addRows > 0 ? "添加成功" : "添加失败");
		return mv;
	}

	@RequestMapping("fill!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String exam_id, @RequestParam String content,
			@RequestParam String answer, @RequestParam String analysis, @RequestParam String description) {
		logger.info("update...exam_id: {}, content: {}, answer: {}, analysis: {}, description: {}", exam_id, content,
				answer, analysis, description);
		Fill fill = new Fill(id, exam_id, content, answer, analysis, description, "");
		int uptRows = fillService.update(fill);

		ModelAndView mv = new ModelAndView("/exam_part/fill/update");
		mv.addObject("fill", fill);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("fill!list.do")
	public ModelAndView list(@RequestParam String exam_id) {
		List<Fill> list = fillService.list(exam_id);
		ModelAndView mv = new ModelAndView("/exam_part/fill/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("fill!find.do")
	public ModelAndView find(@RequestParam String id) {
		Fill fill = fillService.findBy(id);
		ModelAndView mv = new ModelAndView("/exam_part/fill/update");
		mv.addObject("fill", fill);
		mv.addObject("message", "fill 信息");
		return mv;
	}

	@RequestMapping("fill!delete.do")
	public ModelAndView delete(@RequestParam String id, @RequestParam String exam_id) {
		fillService.deleteBy(id);
		return list(exam_id);
	}
}
