package cn.ustb.resource.demo;

import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * ResourceLoader读取，getResource()接收字符串：
 * 1、文件读取资源：file:路径
 * 2、CLASSPATH读取：classpath:路径
 * 3、网络读取：http://路径
 * @author MouseZhang
 *
 */
public class HTTPResourceLoader {
	public static void main(String[] args) throws Exception {
		ResourceLoader loader = new DefaultResourceLoader();
		// 此时要打开本地的Tomcat
		Resource source = loader.getResource("http://localhost:8080/RELEASE-NOTES.txt");
		System.out.println("数据的长度：" + source.contentLength());
		Scanner scan = new Scanner(source.getInputStream());
		scan.useDelimiter("\n");
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
