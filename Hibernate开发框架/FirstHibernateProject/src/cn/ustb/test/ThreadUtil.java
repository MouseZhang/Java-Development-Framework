package cn.ustb.test;

public class ThreadUtil {
	private static ThreadLocal<News> threadLocal = new ThreadLocal<News>();
	public static ThreadLocal<News> getThreadLocal() {
		return threadLocal;
	}
}
