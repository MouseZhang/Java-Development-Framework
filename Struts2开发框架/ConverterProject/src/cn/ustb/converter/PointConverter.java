package cn.ustb.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import cn.ustb.vo.Point;

public class PointConverter extends StrutsTypeConverter {

	// 从String变为对象
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (Point.class.equals(toClass)) { // 要转换的类型为Point类型
			String[] result = values[0].split(",");
			String xValue = result[0].substring(1);
			String yValue = result[1].replace(")", "");
			Point point = new Point();
			point.setX(Double.parseDouble(xValue));
			point.setY(Double.parseDouble(yValue));
			return point;
		}
		return null;
	}

	// 将对象变为String
	@Override
	public String convertToString(Map context, Object o) {
		if (o instanceof Point) { // 要处理的类型为Point
			Point point = (Point) o;
			return "【坐标数据】：(" + point.getX() + "," + point.getY() + ")"; 
		}
		return null;
	}

}
