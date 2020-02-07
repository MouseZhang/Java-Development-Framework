package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 变量操作
 * @author MouseZhang
 *
 */
public class TestELDemoI {
	public static void main(String[] args) {
//		pstr=#myvar context.setVariable("myvar", "Hello World")、
		String pstr = "#root == 'USTB' ? 'Hello': 'World'";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext("USTB");
		System.out.println(exp.getValue(context));
	}
}
