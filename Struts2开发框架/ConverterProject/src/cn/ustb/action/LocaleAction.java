package cn.ustb.action;

import java.util.Locale;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.LocalizedTextUtil;

@SuppressWarnings("serial")
public class LocaleAction extends ActionSupport {
	private Locale loc;
	public void setLoc(Locale loc) {
		this.loc = loc;
	}
	public void insert() {
		String str = LocalizedTextUtil.findDefaultText("welcome", this.loc);
		System.out.println(str);
	}
}
