package cn.ustb.demo;


import java.lang.reflect.Method;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 方法引用
 * @author MouseZhang
 *
 */
public class TestELDemoJ {
	public static void main(String[] args) throws Exception {
		String pstr = "#myInt('123')";
		// 找到Integer.parseInt()这个方法的对象
		Method met = Integer.class.getMethod("parseInt", String.class);
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		// 利用StandardEvaluationContext进行方法的引用注册
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.registerFunction("myInt", met); // 方法进行引用
		System.out.println(exp.getValue(context));
	}
}
