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
 * 修改List集合内容
 * @author MouseZhang
 *
 */
public class TestELDemoR {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		String pstr = "#allData[1]='world'";
		List<String> all = new ArrayList<String>();
		all.add("ustb");
		all.add("hello");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);
		System.out.println(exp.getValue(context));
		System.out.println(all);
	}
}
