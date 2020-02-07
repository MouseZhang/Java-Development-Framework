package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestELSimple {
	public static void main(String[] args) {
		// 1、定义要操作的表达式
		String pstr = "(\"Hello \" + \"World\").substring(#start, #end)";
		// 2、要定义一个表达式的解析器，本次使用SpEL表达式解析器
		// 定义解析器，ExpressionParser是一个操作标准，需要SpelExpressionParser标准处理类
		ExpressionParser parser = new SpelExpressionParser();
		// 3、使用特定的解析器来处理指定的字符串操作
		// 解析给出的字符串表达式，将字符串根据指定的解析器进行解析，而后使用这个生成的表达式
		Expression exp = parser.parseExpression(pstr);
		// 4、定义相关的环境属性（占位变量内容的处理）
		// EvaluationContext用于设置表达式的一些属性信息，因为表达式中可能存在某些占位符
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("start", 6);
		context.setVariable("end", 9);
		System.out.println(exp.getValue(context));
	}
}
