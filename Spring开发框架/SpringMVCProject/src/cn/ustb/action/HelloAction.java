package cn.ustb.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.ustb.vo.News;

@Controller
@RequestMapping("/pages/hello/*")
public class HelloAction {
	
	// 定义验证规则
	private static String insertRule = "nid:int|title:string";
	private static String mimeRule = "image/jpeg,image/jpg,image/png,image/gif";
	@RequestMapping("insert")
	public ModelAndView insert(News vo, MultipartFile pic) throws Exception {
		System.out.println("****** Hello World!!! ******");
		System.out.println("【文件大小】：" + pic.getSize());
		System.out.println(vo);
		return null;
	}
}
