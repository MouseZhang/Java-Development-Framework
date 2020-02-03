package cn.ustb.test;

public class Message {
	public void print() {
		News vo = ThreadUtil.getThreadLocal().get();
		System.out.println("【新闻标题】：" + vo.getTitle());
	}
}
