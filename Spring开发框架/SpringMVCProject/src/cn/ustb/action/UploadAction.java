package cn.ustb.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.ustb.vo.Type;

@Controller
@RequestMapping("/pages/*")
public class UploadAction {
	
	@RequestMapping("insert")
	public ModelAndView insert(Type type, MultipartFile pic) throws Exception {
		System.out.println("【类型名称】：" + type.getTypeTitle());
		System.out.println("【文件类型】：" + pic.getContentType());
		System.out.println("【文件大小】：" + pic.getSize());
		System.out.println("【是否为空】：" + pic.isEmpty());
		System.out.println("【数据流】：" + pic.getInputStream());
		return null;
	}
}
