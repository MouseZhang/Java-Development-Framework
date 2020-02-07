package cn.ustb.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 批处理List集合内容
 * @author MouseZhang
 *
 */
public class TestELDemoT {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		String pstr = "#allData.!['haha:' + #this]";
		List<String> all = new ArrayList<String>();
		all.add("ustb");
		all.add("hello");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);
		System.out.println(exp.getValue(context)); // 创建了一个新的集合
		System.out.println(all);
	}
}
