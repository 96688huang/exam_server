package com.tt.exam.examination.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.examination.bean.Examination;
import com.tt.exam.examination.service.ExaminationService;

@Controller
public class ExaminationControl {
	private final Logger logger = LoggerFactory.getLogger(ExaminationControl.class);

	@Resource
	private ExaminationService examinationService;

	@RequestMapping("examination!add.do")
	public ModelAndView add(@RequestParam String category_id, @RequestParam String name,
			@RequestParam String description) {
		logger.info("add...category_id: {}, name: {}, description: {}", category_id, name, description);
		String id = UuidUtil.genereateId();
		Examination examination = new Examination(id, category_id, name, description);
		int addRows = examinationService.add(examination);

		ModelAndView mv = new ModelAndView("/examination/update");
		mv.addObject("examination", examination);
		mv.addObject("message", addRows > 0 ? "添加成功" : "添加失败");
		return mv;
	}

	@RequestMapping("examination!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String category_id, @RequestParam String name,
			@RequestParam String description) {
		logger.info("update... id: {}, name: {}, description: {}", id, name, description);
		Examination examination = new Examination(id, category_id, name, description);
		int uptRows = examinationService.update(examination);

		ModelAndView mv = new ModelAndView("/examination/update");
		mv.addObject("examination", examination);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("examination!list.do")
	public ModelAndView list(@RequestParam String category_id) {
		List<Examination> list = examinationService.list(category_id);
		ModelAndView mv = new ModelAndView("/examination/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("examination!find.do")
	public ModelAndView find(@RequestParam String id) {
		Examination examination = examinationService.findBy(id);
		ModelAndView mv = new ModelAndView("/examination/update");
		mv.addObject("examination", examination);
		mv.addObject("message", examination.getName() + " 信息");
		return mv;
	}

	@RequestMapping("examination!delete.do")
	public ModelAndView delete(@RequestParam String id, @RequestParam String category_id) {
		examinationService.deleteBy(id);
		return list(category_id);
	}
}
