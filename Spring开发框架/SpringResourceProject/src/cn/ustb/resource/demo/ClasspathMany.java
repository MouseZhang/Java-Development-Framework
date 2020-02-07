package cn.ustb.resource.demo;

import java.util.Scanner;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 路径通配符：
 * 1、?，匹配任意一个字符
 * 2、*，匹配零个、一个或多个任意字符
 * 3、**，匹配零个、一个或多个任意目录
 * @author MouseZhang
 *
 */

public class ClasspathMany {
	public static void main(String[] args) throws Exception {
		ResourcePatternResolver loader = new PathMatchingResourcePatternResolver();
		// 多个路径的匹配
		Resource[] source = loader.getResources("classpath:cn/msg/**/applicationContext-?.xml");
		for (int i = 0; i < source.length; i++) {
			System.out.println("文件名称：" + source[i].getFile() + "，文件长度：" + source[i].contentLength());
		}
	}
}
