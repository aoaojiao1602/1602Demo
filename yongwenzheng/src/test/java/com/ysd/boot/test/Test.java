package com.ysd.boot.test;

import com.ysd.boot.tool.PasswordEncoder;

public interface Test {

	public static void main(String[] args) {
		PasswordEncoder encoderMd5 = new PasswordEncoder("王五", "MD5");
		String encodePass = encoderMd5.encode("123456", 5);// 用户名做盐,哈希五次MD5加密
	   System.err.println(encodePass);
	}
}
