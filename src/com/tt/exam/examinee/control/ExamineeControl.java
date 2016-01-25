package com.tt.exam.examinee.control;

import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("message", "hello 你好");
		return mv;
	}

	@RequestMapping("examinee!register.do")
	public ModelAndView register(@RequestParam String account, @RequestParam String password, @RequestParam String name) {
		logger.info("register...account: {}, password: {}, name: {}", account, password, name);

		examineeService.register(new Examinee(UUID.randomUUID().toString(), account, password, name));
		ModelAndView mv = new ModelAndView("register_succ");
		mv.addObject("account", account);
		mv.addObject("password", password);
		return mv;
	}
}
