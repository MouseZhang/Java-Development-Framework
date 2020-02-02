package cn.ustb.converter;

import java.lang.reflect.Member;
import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class StringToLocaleConverter extends DefaultTypeConverter {
	
	// 主要是实现数据转换的
	@Override
	public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName,
			Object value, Class toType) {
		// 在Struts 2.x里面所有的参数都是以String[]的形式出现的
		String result = ((String[]) value) [0]; // 取得输入参数
		if (Locale.class.equals(toType)) { // 要转换的目标类型为locale
			String[] str = result.split("_");
			Locale loc = new Locale(str[0], str[1]);
			return loc;
		}
		return null;
	}
	
}
