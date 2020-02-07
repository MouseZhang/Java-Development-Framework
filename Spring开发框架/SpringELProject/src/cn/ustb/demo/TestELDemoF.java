package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


// 三目运算符操作
public class TestELDemoF {
	public static void main(String[] args) {
		// pstr=1 > 2 ? 'Hello': 'World'、null ?:'World'、true ?:'World'
		String pstr = "true ?'Hello' : 'World'";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
