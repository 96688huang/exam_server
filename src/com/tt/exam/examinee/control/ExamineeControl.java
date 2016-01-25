package com.tt.exam.examinee.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.examinee.bean.Examinee;
import com.tt.exam.examinee.service.ExamineeService;

@Controller
public class ExamineeControl {
	private final Logger logger = LoggerFactory.getLogger(ExamineeControl.class);

	@Resource
	private ExamineeService examineeService;

	@RequestMapping("examinee!login.do")
	public ModelAndView login(@RequestParam String account, @RequestParam String password) {
		logger.info("login...account: {}, password: {}", account, password);
		ModelAndView mv = new ModelAndView("/examinee/login");
		mv.addObject("message", "hello 你好");
		return mv;
	}

	@RequestMapping("examinee!register.do")
	public ModelAndView register(@RequestParam String account, @RequestParam String password, @RequestParam String name) {
		logger.info("register...account: {}, password: {}, name: {}", account, password, name);

		String id = UuidUtil.genereateId();
		Examinee examinee = new Examinee(id, account, password, name);
		examineeService.register(examinee);
		ModelAndView mv = new ModelAndView("/examinee/examinee_upt");
		mv.addObject("examinee", examinee);
		mv.addObject("message", "注册成功");
		return mv;
	}

	@RequestMapping("examinee!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String account, @RequestParam String password,
			@RequestParam String name) {
		logger.info("update... id: {}, account: {}, password: {}, name: {}", id, account, password, name);
		Examinee examinee = new Examinee(id, account, password, name);
		examineeService.update(examinee);

		ModelAndView mv = new ModelAndView("/examinee/examinee_upt");
		mv.addObject("examinee", examinee);
		mv.addObject("message", "修改成功");
		return mv;
	}

	@RequestMapping("examinee!list.do")
	public ModelAndView list() {
		List<Examinee> list = examineeService.list();
		ModelAndView mv = new ModelAndView("/examinee/examinee_list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("examinee!find.do")
	public ModelAndView find(@RequestParam String id) {
		Examinee examinee = examineeService.findBy(id);
		ModelAndView mv = new ModelAndView("/examinee/examinee_upt");
		mv.addObject("examinee", examinee);
		mv.addObject("message", examinee.getAccount() + " 信息");
		return mv;
	}

	@RequestMapping("examinee!delete.do")
	public ModelAndView delete(@RequestParam String id) {
		examineeService.deleteBy(id);
		return list();
	}
}
