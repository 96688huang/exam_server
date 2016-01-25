package com.tt.exam.common.utils;

import java.util.UUID;

public class UuidUtil {
	public static String genereateId() {
		return UUID.randomUUID().toString();
	}
}
