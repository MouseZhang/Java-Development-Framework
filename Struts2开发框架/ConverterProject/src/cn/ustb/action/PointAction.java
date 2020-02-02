package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.Point;

@SuppressWarnings("serial")
public class PointAction extends ActionSupport {
	private Point point;
	public void setPoint(Point point) {
		this.point = point;
	}
	public Point getPoint() {
		return point;
	}
	public String insert() {
		// 浏览器输入地址：http://localhost:8080/ConverterProject/PointAction!insert.action?point=(1.21,3.56)
		System.out.println("【参数内容】X坐标：" + this.point.getX() + "，Y坐标：" + this.point.getY());
		return ActionSupport.SUCCESS;
	}
}
