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
 * 修改Map集合内容
 * @author MouseZhang
 *
 */
public class TestELDemoS {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		String pstr = "#allData['ustb']='欢迎访问ustb'";
		Map<String, String> all = new HashMap<String, String>();
		all.put("ustb", "www.ustb.cn");
		all.put("hello", "world");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);
		System.out.println(exp.getValue(context));
		System.out.println(all);
	}
}
