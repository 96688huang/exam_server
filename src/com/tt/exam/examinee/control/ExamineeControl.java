package com.tt.exam.examinee.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tt.exam.common.utils.UuidUtil;
import com.tt.exam.examinee.bean.Examinee;
import com.tt.exam.examinee.service.ExamineeService;
import com.tt.exam.utils.EncodUtil;
import com.tt.exam.utils.SessionUtil;

@Controller
public class ExamineeControl {
	private final Logger logger = LoggerFactory.getLogger(ExamineeControl.class);

	@Resource
	private ExamineeService examineeService;

	@RequestMapping("examinee!login.do")
	public ModelAndView login(@RequestParam String account, @RequestParam String password, HttpSession session) {
		logger.info("login...account: {}, password: {}", account, password);
		String pwdMd5 = EncodUtil.encodeByMd5(password);
		Examinee examinee = examineeService.findBy(account, pwdMd5);
		if (examinee != null) {
			examinee.setPassword(null); // 去除密码
			SessionUtil.addExaminee(session, examinee); // 存入session
		}
		String message = (examinee == null) ? "用记名或密码错误" : "登陆成功";

		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("message", message);
		mv.addObject("examinee", examinee);
		return mv;
	}

	@RequestMapping("examinee!register.do")
	public ModelAndView register(@RequestParam String account, @RequestParam String password, @RequestParam String name) {
		logger.info("register...account: {}, password: {}, name: {}", account, password, name);
		String id = UuidUtil.genereateId();
		String pwdMd5 = EncodUtil.encodeByMd5(password);
		Examinee examinee = new Examinee(id, account, pwdMd5, name);
		int addRows = examineeService.register(examinee);

		ModelAndView mv = new ModelAndView("/examinee/update");
		mv.addObject("examinee", examinee);
		mv.addObject("message", addRows > 0 ? "注册成功" : "注册失败");
		return mv;
	}

	@RequestMapping("examinee!update.do")
	public ModelAndView update(@RequestParam String id, @RequestParam String account, @RequestParam String password,
			@RequestParam String name, HttpSession session) {
		logger.info("update... id: {}, account: {}, password: {}, name: {}", id, account, password, name);
		Examinee examinee = new Examinee(id, account, password, name);
		int uptRows = examineeService.update(examinee);
		if (uptRows > 0) {
			SessionUtil.addExaminee(session, examinee); // 更新session
		}

		ModelAndView mv = new ModelAndView("/examinee/update");
		mv.addObject("examinee", examinee);
		mv.addObject("message", uptRows > 0 ? "修改成功" : "修改失败");
		return mv;
	}

	@RequestMapping("examinee!list.do")
	public ModelAndView list() {
		List<Examinee> list = examineeService.list();
		ModelAndView mv = new ModelAndView("/examinee/list");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("examinee!find.do")
	public ModelAndView find(@RequestParam String id) {
		Examinee examinee = examineeService.findBy(id);
		ModelAndView mv = new ModelAndView("/examinee/update");
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
