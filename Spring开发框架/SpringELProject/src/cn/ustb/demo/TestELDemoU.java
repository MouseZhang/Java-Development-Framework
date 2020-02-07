package cn.ustb.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 批处理Map集合内容
 * @author MouseZhang
 *
 */
public class TestELDemoU {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		String pstr = "#allData.![#this.key + ' - ' + #this.value]";
		Map<String, String> all = new HashMap<String, String>();
		all.put("ustb", "www.ustb.cn");
		all.put("hello", "world");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);
		System.out.println(exp.getValue(context)); // 形成了一个新的List
		System.out.println(all);
	}
}
