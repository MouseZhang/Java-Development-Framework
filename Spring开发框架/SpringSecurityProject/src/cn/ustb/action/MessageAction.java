package cn.ustb.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ustb.vo.Message;

@Controller
@RequestMapping("/pages/back/message/*")
public class MessageAction {
	
	@RequestMapping("message_insertPre")
	@Secured(value={"ROLE_ADMIN","IP_LOCAL_HOST"}) // 此时由于操作者是处于服务器的本地IP服务上，所以此时可以直接进行数据的操作
	public ModelAndView insertPre() {
		ModelAndView mav = new ModelAndView("back/message/message_insert");
		return mav;
	}
	
	@RequestMapping("message_insert")
	@Secured(value={"ROLE_ADMIN","IP_LOCAL_HOST"})
	public ModelAndView insert(Message msg) {
		System.out.println("【增加数据】数据编号：" + msg);
		ModelAndView mav = new ModelAndView("forward");
		mav.addObject("msg", "信息添加成功！");
		mav.addObject("url", "pages/back/message/message_insertPre.action");
		return mav;
	}
	
	@RequestMapping("message_list")
	@Secured(value={"ROLE_ADMIN","ROLE_USER","IP_LOCAL_HOST"})
	public ModelAndView list() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("【当前用户】：" + userDetails.getUsername());
		System.out.println("【登录密码】：" + userDetails.getPassword());
		System.out.println("【用户角色】：" + userDetails.getAuthorities());
		ModelAndView mav = new ModelAndView("back/message/message_list");
		List<Message> all = new ArrayList<Message>();
		for (int i = 0; i < 10; i++) {
			Message msg = new Message();
			msg.setMid(i);
			msg.setTitle("USTB - " + i);
			msg.setContent("www.ustb.cn");
			all.add(msg);
		}
		mav.addObject("allMessages", all);
		return mav;
	}
	
	@RequestMapping("message_delete")
	@Secured(value={"ROLE_ADMIN"})
	public ModelAndView delete(int mid) {
		System.out.println("【删除数据】数据编号：" + mid);
		ModelAndView mav = new ModelAndView("forward");
		mav.addObject("msg", "信息删除成功！");
		mav.addObject("url", "pages/back/message/message_list.action");
		return mav;
	}
	
}
