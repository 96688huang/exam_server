package com.tt.exam.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author chenxs
 * @date 2013年11月20日
 */
public class ReflectionUtil {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

	/**
	 * 设置对象属性值
	 * @param obj	对象值
	 * @param key	属性名称
	 * @param value	属性值
	 * @return
	 */
	public static boolean setFieldValue(Object obj, String key, Object value) {
		Class clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (("set" + key).equalsIgnoreCase(method.getName())) {
				try {
					method.invoke(obj, value);
				} catch (IllegalArgumentException e) {
					logger.error("%s调用方法%s出错", clazz.getName(), method.getName() + "参数错误");
				} catch (IllegalAccessException e) {
					logger.error("%s调用方法%s出错", clazz.getName(), method.getName() + "参数错误");
				} catch (InvocationTargetException e) {
					logger.error("%s调用方法%s出错", clazz.getName(), method.getName() + "参数错误");
				}
				return true;
			}
		}
		logger.warn("%s找不到%s方法", clazz.getName(), "set" + StringUtils.capitalize(key));
		return false;
	}

	/**
	 * 取得属性值
	 * @param obj	对象值
	 * @param key	属性名称
	 * @return
	 * 	属性值
	 */
	public static Object getFieldValue(Object obj, String key) {
		Class clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (("get" + key).equalsIgnoreCase(method.getName())) {
				try {
					return method.invoke(obj);
				} catch (IllegalArgumentException e) {
					logger.error("%s调用方法%s出错", clazz.getName(), method.getName() + "值错误");
				} catch (IllegalAccessException e) {
					logger.error("%s调用方法%s出错", clazz.getName(), method.getName() + "值错误");
				} catch (InvocationTargetException e) {
					logger.error("%s调用方法%s出错", clazz.getName(), method.getName() + "值错误");
				}
			}
		}
		logger.warn("%s类找不到%s方法", obj.getClass().getName(), "get" + StringUtils.capitalize(key));
		return null;
	}

}
