package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


// 正则运算操作
public class TestELDemoG {
	public static void main(String[] args) {
		// pstr='100' matches '\\d{3}'、'100'.matches('\\d{3}')
		String pstr = "'100'.matches('\\d{3}')";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
