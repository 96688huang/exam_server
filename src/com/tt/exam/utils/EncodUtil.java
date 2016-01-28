package com.tt.exam.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class EncodUtil {

	public static String encodeByMd5(String data) {
		return DigestUtils.md5Hex(data);
	}
}
