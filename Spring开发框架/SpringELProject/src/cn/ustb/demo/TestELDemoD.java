package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


// 逻辑表达式
public class TestELDemoD {
	public static void main(String[] args) {
		// pstr='a' EQ 'A' AND 10 > 5、'a' EQ 'A' || 10 > 5、!('a' EQ 'A') AND 10 > 5
		String pstr = "!('a' EQ 'A') AND 10 > 5";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
