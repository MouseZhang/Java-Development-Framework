package cn.ustb.test;

import cn.ustb.util.MD5Code;

public class TestMD5 {
	public static void main(String[] args) {
		System.out.println(new MD5Code().getMD5ofStr("hello"));
		System.out.println(new MD5Code().getMD5ofStr("java"));
	}
}
