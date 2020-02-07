package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestELSimpleMath {
	public static void main(String[] args) {
		// 1、定义要操作的表达式
		String pstr = "1 + 2";
		// 2、要定义一个表达式的解析器，本次使用SpEL表达式解析器
		ExpressionParser parser = new SpelExpressionParser();
		// 3、使用特定的解析器来处理指定的字符串操作
		Expression exp = parser.parseExpression(pstr);
		// 4、定义相关的环境属性（占位变量内容的处理）
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
