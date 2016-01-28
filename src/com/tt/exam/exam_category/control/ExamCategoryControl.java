package com.tt.exam.exam_category.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.exam_category.bean.ExamCategory;
import com.tt.exam.exam_category.service.ExamCategoryService;
import com.tt.exam.examinee.bean.Examinee;
import com.tt.exam.utils.SessionUtil;

@Controller
public class ExamCategoryControl {
	private final Logger logger = LoggerFactory.getLogger(ExamCategoryControl.class);

	@Resource
	private ExamCategoryService examCategoryService;

	@RequestMapping("examCategory!list.do")
	public ModelAndView list(HttpSession session) {
		logger.info("list exam category");

		Examinee examinee = SessionUtil.getExaminee(session);
		ExamCategory category = new ExamCategory();
		category.setOwner_id(examinee.getId());
		List<ExamCategory> list = examCategoryService.list(category);

		ModelAndView mv = new ModelAndView("/exam_category/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("examCategory!add.do")
	public ModelAndView add(@RequestParam String name, @RequestParam String description, HttpSession session) {
		logger.info("add exam category.");
		Examinee examinee = SessionUtil.getExaminee(session);
		String id = UuidUtil.genereateId();
		ExamCategory category = new ExamCategory(id, examinee.getId(), name, description);
		int addRows = examCategoryService.add(category);

		String message = addRows > 0 ? "考试类别添加成功" : "考试类别添加失败";
		ModelAndView mv = new ModelAndView("/exam_category/update");
		mv.addObject("examCategory", category);
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping("examCategory!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String name, @RequestParam String description,
			HttpSession session) {
		logger.info("update exam category. id: {}, name: {}, description: {},", id, name, description);
		Examinee examinee = SessionUtil.getExaminee(session);
		ExamCategory category = new ExamCategory(id, examinee.getId(), name, description);
		int uptRows = examCategoryService.update(category);

		ModelAndView mv = new ModelAndView("/exam_category/update");
		mv.addObject("examCategory", category);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("examCategory!find.do")
	public ModelAndView find(@RequestParam String id, HttpSession session) {
		Examinee examinee = SessionUtil.getExaminee(session);
		ExamCategory category = new ExamCategory();
		category.setId(id);
		category.setOwner_id(examinee.getId());
		List<ExamCategory> list = examCategoryService.list(category);
		category = CollectionUtils.isEmpty(list) ? null : list.get(0);

		ModelAndView mv = new ModelAndView("/exam_category/update");
		mv.addObject("examCategory", category);
		mv.addObject("message", category.getName() + " 信息");
		return mv;
	}

	@RequestMapping("examCategory!delete.do")
	public ModelAndView delete(@RequestParam String id, HttpSession session) {
		Examinee examinee = SessionUtil.getExaminee(session);

		examCategoryService.deleteBy(id, examinee.getId());
		return list(session);
	}
}
