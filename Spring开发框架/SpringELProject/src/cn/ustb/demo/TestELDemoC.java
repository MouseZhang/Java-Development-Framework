package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


// 关系表达式
public class TestELDemoC {
	public static void main(String[] args) {
		// pstr=1 == 2、1 EQ 2、1 NE 2、1 > 2、1 GT 2、1 LE 2、10 BETWEEN {5,20}
		String pstr = "10 BETWEEN {5,20}";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
