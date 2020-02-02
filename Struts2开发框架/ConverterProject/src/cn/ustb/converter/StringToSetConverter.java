package cn.ustb.converter;

import java.lang.reflect.Member;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class StringToSetConverter extends DefaultTypeConverter {
	
	@Override
	public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName,
			Object value, Class toType) {
		if (Set.class.equals(toType)) { // 判断目标类型是否为Set集合
			Set<String> set = new HashSet<String>();
			String str = ((String[]) value)[0];
			String[] result = str.split("\\|");
			for (int i = 0; i < result.length; i++) {
				set.add(result[i]);
			}
			return set;
		}
		return null;
	}
	
}
