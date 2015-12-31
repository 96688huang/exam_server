package com.tt.exam.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tt.exam.common.constant.PageUrlFlagEnum;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {

	/**
	 *	serialVersionUID
	 */
	private static final long serialVersionUID = -3095383187712244799L;

	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

	private static final String INDEX_PAGE = PageUrlFlagEnum.INDEX_PAGE.getUrlFlag();

	private String account;
	private String password;
	private String name;

	public String login() throws Exception {
		try {
			logger.info("login --> account: {}, password: {}", account, password);
			return INDEX_PAGE;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public String register() throws Exception {
		logger.info("register --> account: {}, password: {}, name: {}", account, password, name);
		return INDEX_PAGE;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
