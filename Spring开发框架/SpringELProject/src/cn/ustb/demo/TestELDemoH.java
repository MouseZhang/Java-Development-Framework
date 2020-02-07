package cn.ustb.demo;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * Class类型表达式
 * 1、T(类)
 * 2、T(类).静态属性
 * 3、T(类).静态方法
 * 4、无参构造
 * 5、有参构造
 * @author MouseZhang
 *
 */
public class TestELDemoH {
	public static void main(String[] args) {
//		pstr=T(String) 取得Class类对象、T(java.util.Date)、T(Integer).MAX_VALUE、T(Integer).parseInt('123')
//		new java.util.Date()、new String('hello')
		String pstr = "'hello' instanceof T(String)";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(pstr);
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
