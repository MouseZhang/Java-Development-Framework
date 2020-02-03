package cn.ustb.test;

public class TestMessage {
	public static void main(String[] args) {
		News vo = new News();
		vo.setTitle("www.ustb.cn");
		Message msg = new Message();
		ThreadUtil.getThreadLocal().set(vo);
		msg.print();
	}
}
