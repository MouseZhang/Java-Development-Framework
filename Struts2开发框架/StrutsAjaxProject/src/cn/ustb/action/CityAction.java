package cn.ustb.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class CityAction extends ActionSupport {
	public void list() { // 利用多业务处理
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		JSONObject all = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < 10; i++) {
			JSONObject temp = new JSONObject();
			temp.put("cid", i);
			temp.put("title", "城市名称-" + i);
			array.add(temp);
		}
		all.put("allCities", array);
		try {
			ServletActionContext.getResponse().getWriter().print(all);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
