package cn.ustb.vo;

/**
 * 以下两个方法只是在Spring中才可以使用，实际上Java运行里依靠构造方法进行初始化，
 * 依靠finalize()方法完成销毁
 * @author MouseZhang
 *
 */
public class CompanyO {
	public void init() {
		System.out.println("##### 公司初始化 #####");
	}
	public void destory() {
		System.out.println("##### 公司销毁 #####");
	}
}
