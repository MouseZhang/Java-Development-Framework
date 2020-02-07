package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

// 自定义表达式边界
public class TestELAdvanced {
	public static void main(String[] args) {
		// 1、定义要操作的表达式
		String pstr = "#[1 + 2]";
		// 2、要定义一个表达式的解析器，本次使用SpEL表达式解析器
		ExpressionParser parser = new SpelExpressionParser();
		// 3、使用特定的解析器来处理指定的字符串操作
		// 使用匿名内部类
		Expression exp = parser.parseExpression(pstr, new ParserContext() {
			
			@Override
			public boolean isTemplate() { // 使用模板
				return true;
			}
			
			@Override
			public String getExpressionSuffix() { // 设置结束部分
				return "]";
			}
			
			@Override
			public String getExpressionPrefix() { // 设置开头部分
				return "#[";
			}
		});
		// 4、定义相关的环境属性（占位变量内容的处理）
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("start", 6);
		context.setVariable("end", 9);
		System.out.println(exp.getValue(context));
	}
}
