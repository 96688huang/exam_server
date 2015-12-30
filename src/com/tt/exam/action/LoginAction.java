package com.tt.exam.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tt.exam.common.constant.PageUrlFlagEnum;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	/**
	 *	serialVersionUID
	 */
	private static final long serialVersionUID = -3095383187712244799L;

	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

	private static final String INDEX_PAGE = PageUrlFlagEnum.INDEX_PAGE.getUrlFlag();

	private String account;
	private String password;

	public String login() throws Exception {
		try {
			logger.info("account: {}, password: {}", account, password);
			return INDEX_PAGE;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
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

}
