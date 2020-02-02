package cn.ustb.util.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

public class ValidateUtil {
	/**
	 * 进行数据验证的操作方法
	 * @param actionObject 表示要触发此操作的Action类
	 * @param rule 每个Action类中定义的规则
	 * @param params 表示所有的输入参数
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean validate(Object actionObject, String rule, Map<String, Object> params) {
		boolean flag = false; // 综合的验证结果
		// 取得增加错误信息的操作方法，通过此方法保存错误信息
		try {
			Method addFieldErrorMethod = actionObject.getClass().getMethod("addFieldError", String.class, String.class);
			// 通过此方法取得错误的提示信息
			Method textMethod = actionObject.getClass().getMethod("getText", String.class);
			//		// 需要知道有哪些参数
	//		Iterator<Map.Entry<String, Object>> iter = params.entrySet().iterator();
	//		while (iter.hasNext()) {
	//			Map.Entry<String, Object> map = iter.next();
	//			String[] str = (String[]) map.getValue();
	//			System.out.println(map.getKey() + " = " + Arrays.toString(str));
	//		}
			// 所有的验证操作都应该由rule发起，里面的组成为“参数名称:类型”
			String[] result = rule.split("\\|"); // 取出每一组验证规则
			String text = null; // 保存每一个的错误提示信息
			for (int i = 0; i < result.length; i++) { // 表示此处循环每一处验证
				String[] temp = result[i].split(":"); // 取出参数名称以及验证规则
				String[] paramValue = (String[]) params.get(temp[0]);
				for (int j = 0; j < paramValue.length; j++) { // 循环每一个数组内容
					switch(temp[1]) { // 进行有效的验证
						case "string": {
							flag = ValidateUtil.validateString(paramValue[j]);
							if (!flag) { // 没有验证成功
								text = (String) textMethod.invoke(actionObject, "string.validate.error.msg");
								
							}
							break;
						}
						case "int": {
							flag = ValidateUtil.validateInt(paramValue[j]);
							if (!flag) { // 没有验证成功
								text = (String) textMethod.invoke(actionObject, "number.validate.error.msg");
							}
							break;
						}
						case "double": {
							flag = ValidateUtil.validateDouble(paramValue[j]);
							if (!flag) { // 没有验证成功
								text = (String) textMethod.invoke(actionObject, "number.validate.error.msg");
							}
							break;
						}
						case "date": {
							flag = ValidateUtil.validateDate(paramValue[j]);
							if (!flag) { // 没有验证成功
								text = (String) textMethod.invoke(actionObject, "date.validate.error.msg");
							}
							break;
						}
					}
					if (!flag) { // 验证失败，进行信息保存
						addFieldErrorMethod.invoke(actionObject, temp[0], text);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 进行字符串的操作验证
	 * @param str 要验证的内容
	 * @return 如果字符串为空或者长度为0，返回false，否则返回true
	 */
	public static boolean validateString(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 进行数字的验证操作，验证之前首先要判断数据是否为空
	 * @param str 要验证的内容
	 * @return 如果是数字组成返回true，否则返回false
	 */
	public static boolean validateInt(String str) {
		if (validateString(str)) { // 首先判断数据是否合法
			return str.matches("\\d+");
		} else {
			return false;
		}
	}
	
	/**
	 * 进行小数的验证操作，验证之前判断数据是否为空
	 * @param str 要验证的内容
	 * @return 如果字符串由小数所组成返回true，否则返回false
	 */
	public static boolean validateDouble(String str) {
		if (validateString(str)) { // 首先判断数据是否合法
			return str.matches("\\d+(\\.\\d+)?");
		} else {
			return false;
		}
	}
	
	/**
	 * 验证字符串是否是日期或者是日期时间类型
	 * @param str 要验证的内容
	 * @return 如果字符串是日期或者日期时间则返回true，否则返回false
	 */
	public static boolean validateDate(String str) {
		if (validateString(str)) {
			if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
				return true;
			} else { // 有可能是日期时间类型
				return str.matches("\\d{4}-\\\\d{2}-\\\\d{2} \\d{2}:\\d{2}:\\d{2}");
			}
		}
		return false;
	}
	
}
