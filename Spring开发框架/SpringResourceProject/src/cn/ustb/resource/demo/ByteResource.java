package cn.ustb.resource.demo;

import java.util.Scanner;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;


// 内存读取
public class ByteResource {
	public static void main(String[] args) throws Exception {
		// 此处的内存处理流与之前的ByteArrayInputStream使用形式相似
		Resource source = new ByteArrayResource("hello world".getBytes());
		System.out.println("数据的长度：" + source.contentLength());
		// 如果给出InputStream，那么可以利用Scanner进行简化读取
		// getInputStream是通过父接口InputStreamSource继承而来
		Scanner scan = new Scanner(source.getInputStream());
		scan.useDelimiter("\n");
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
	}
}
