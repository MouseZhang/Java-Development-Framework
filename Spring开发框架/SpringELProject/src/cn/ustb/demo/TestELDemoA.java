package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


// 字面表达式
public class TestELDemoA {
	public static void main(String[] args) {
		// pstr='Hello ' + 'World'、1.2E10、true、null
		String pstr = "1.2E10";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context, long.class));
	}
}
