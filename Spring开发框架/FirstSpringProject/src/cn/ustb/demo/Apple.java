package cn.ustb.demo;

public class Apple implements IFruit {
	
	public Apple() {
		System.out.println("*******************");
	}

	@Override
	public void eat() {
		System.out.println("***** 吃苹果！");
	}

}
