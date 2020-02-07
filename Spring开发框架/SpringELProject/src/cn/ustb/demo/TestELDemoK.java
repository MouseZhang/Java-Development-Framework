package cn.ustb.demo;


import java.util.Date;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 表达式调用属性
 * @author MouseZhang
 *
 */
public class TestELDemoK {
	public static void main(String[] args) {
		String pstr = "time";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext(new Date());
		System.out.println(exp.getValue(context));
	}
}
