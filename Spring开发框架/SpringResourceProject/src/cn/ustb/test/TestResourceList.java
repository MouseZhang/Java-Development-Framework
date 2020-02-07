package cn.ustb.test;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import cn.ustb.resource.util.ResourceList;

public class TestResourceList {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceList rblist = ctx.getBean("rblist", ResourceList.class);
		Iterator<Resource> iter = rblist.getResource().iterator();
		while (iter.hasNext()) {
			Scanner scan = new Scanner(iter.next().getInputStream());
			scan.useDelimiter("\n");
			while (scan.hasNext()) {
				System.out.println(scan.next());
			}
			System.out.println("*******************");
		}
	}
}
