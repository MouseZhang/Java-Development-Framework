package cn.ustb.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.ustb.service.IMessageService;
import cn.ustb.vo.Message;
import cn.ustb.vo.Type;

@Controller // 这里定义了一个控制器
@RequestMapping("/pages/back/message/*") // 表示映射操作，代表整体的访问路径
public class MessageAction {
	// 为整个demo()方法定义映射子路径
	// method=RequestMethod.GET配置表示此方法只能使用GET请求模式进行触发
	// 设置为method=RequestMethod.POST时，则只能够由表单提交到方法上
	// 不写method表示既支持POST请求，也支持GET请求
//	@RequestMapping(value="hello_demo", method=RequestMethod.GET)
//	public ModelAndView demo(Message msg) {
//		// URL地址：http://localhost:8080/SpringMVCProject/pages/back/message/hello_demo.action?mid=10&title=世界和平&type.title=头条新闻
//		ModelAndView mav = new ModelAndView("/pages/forward.jsp");
//		mav.addObject("msg", "消息信息添加成功！");
//		mav.addObject("url", "index.jsp");
//		System.out.println(msg);
//		return mav;
//	}
	
	@Resource
	private IMessageService messageService;
	
	@Resource
	private MessageSource messageSource; // 使用依赖注入进行对象的设置
	
	@RequestMapping(value="message_insert")
	public ModelAndView insert(Message msg) { // 接收一个参数对象
		ModelAndView mav = new ModelAndView("/pages/forward.jsp");
		try {
			System.out.println(this.messageService.insert(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("msg", "消息信息添加成功！");
		mav.addObject("url", "pages/back/message/message_insert.jsp");
		return mav;
	}
	
	// URL：http://localhost:8080/SpringMVCProject/pages/back/message/message_insertPre.action
	@RequestMapping(value="message_insertPre")
	public ModelAndView insertPre() {
		// 像资源文件读取操作、转换器等在实际的开发中，应该在Action的统一父类中执行操作！！！
		System.out.println("属性内容：" + this.messageSource.getMessage("info.msg", new Object[] {"www.ustb.cn"}, Locale.getDefault()));
		System.out.println("属性内容：" + this.messageSource.getMessage("message.insert.action", null, null));
		// 此时完整路径为：/WEB-INF/pages/back/message/message_insert.jsp
		ModelAndView mav = new ModelAndView("back/message/message_insert");
		return mav;
	}
	
	@RequestMapping("inner")
	public ModelAndView inner(Message msg, HttpServletRequest request, HttpServletResponse response) { // 实现内置对象的操作
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		System.out.println("【绝对路径】：" + application.getRealPath("/"));
		System.out.println("【Session ID】：" + session.getId());
		try {
			response.getWriter().print("<h1>www.ustb.cn<h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // 返回null表示不跳转
	}
	
	
	@RequestMapping("message_update")
	public ModelAndView update(Message msg, Type type) { // 此时接收两个参数对象
		msg.setType(type);
		ModelAndView mav = new ModelAndView("/pages/forward.jsp");
		try {
			System.out.println(this.messageService.update(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("msg", "消息信息修改成功！");
		mav.addObject("url", "index.jsp");
		return mav;
	}
	
	// URL：http://localhost:8080/SpringMVCProject/pages/back/message/message_delete.action?ids=1|2|3|
	@RequestMapping("message_delete")
	public ModelAndView delete(@RequestParam(value="paramids",defaultValue="0") String ids) { // 在进行非vo类型数据传输的时候，往往会直接传递一个具体的参数名称
		ModelAndView mav = new ModelAndView("/pages/forward.jsp");
		Set<Integer> set = new HashSet<Integer>();
		String[] result = ids.split("\\|");
		for (int i = 0; i < result.length; i++) {
			set.add(Integer.parseInt(result[i]));
		}
		try {
			System.out.println(this.messageService.delete(set));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("msg", "消息信息删除成功！");
		mav.addObject("url", "index.jsp");
		return mav;
	}
	
	@RequestMapping(value="message_get", method=RequestMethod.GET)
	public ModelAndView get(int mid) {
		ModelAndView mav = new ModelAndView("/pages/forward.jsp");
		try {
			System.out.println("返回对象：" + this.messageService.get(mid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("msg", "单条消息信息查询成功！");
		mav.addObject("url", "index.jsp");
		return mav;
	}
	
	// URL：http://localhost:8080/SpringMVCProject/pages/back/message/message_list.action?col=title&kw=&cp=1&ls=5
	@RequestMapping("message_list")
	public ModelAndView list(String col, String kw, int cp, int ls) {
		ModelAndView mav = new ModelAndView("/pages/forward.jsp");
		System.out.println("*****【分页显示参数】col = " + col);
		System.out.println("*****【分页显示参数】kw = " + kw);
		System.out.println("*****【分页显示参数】cp = " + cp);
		System.out.println("*****【分页显示参数】ls = " + ls);
		try {
			System.out.println("返回对象：" + this.messageService.list(col, kw, cp, ls));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("msg", "分页消息信息查询成功！");
		mav.addObject("url", "index.jsp");
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) { // 进行WEB数据的转换绑定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 注册一个专门的日期转换器的操作类，并且允许输入的数据为空
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
}