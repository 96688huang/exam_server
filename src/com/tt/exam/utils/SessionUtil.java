package com.tt.exam.utils;

import javax.servlet.http.HttpSession;

import com.tt.exam.examinee.bean.Examinee;

public class SessionUtil {

	public static Examinee getExaminee(HttpSession session) {
		return (Examinee) session.getAttribute("examinee");
	}

	public static void addExaminee(HttpSession session, Examinee examinee) {
		session.setAttribute("examinee", examinee);
	}

	public static void removeExaminee(HttpSession session, Examinee examinee) {
		session.removeAttribute("examinee");
	}
}
