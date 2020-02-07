package cn.ustb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 索引取得集合
 * @author MouseZhang
 *
 */
public class TestELDemoO {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		String pstr = "{100,200,300}[1]";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
