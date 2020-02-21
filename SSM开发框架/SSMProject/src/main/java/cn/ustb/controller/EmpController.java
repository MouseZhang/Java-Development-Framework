package cn.ustb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ustb.service.EmpService;
import cn.ustb.vo.Emp;
import cn.ustb.vo.Msg;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	/**
	 * 查询雇员数据（分页查询），使用PageHelper分页插件
	 * @param pn
	 * @param model
	 * @return
	 */
	public String getEmps(@RequestParam(value="pn", defaultValue="1") int pn, Model model) {
		// 查询前设置查询当前页码、每页显示条数
		PageHelper.startPage(pn, 5);
		List<Emp> emps = empService.getAll();
		// 使用PageInfo对查询结果进行包装，第二个参数表示连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	/**
	 * @ResponseBody用于将返回的对象转为Json，需要导入Jackson包
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsByJson(@RequestParam(value="pn", defaultValue="1") int pn) {
		PageHelper.startPage(pn, 5);
		List<Emp> emps = empService.getAll();
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 雇员数据信息保存（POST请求）
	 * 支持JSR303校验，必须导入Hibernate-Validator包
	 * @param emp
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	@ResponseBody
	public Msg insertEmp(@Valid Emp emp, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error: errors) {
				map.put(error.getField(), error.getDefaultMessage());
			}
			return Msg.failure().add("errorFields", map);
		} else {
			empService.insert(emp);
			return Msg.success();
		}
	}
	
	/**
	 * 检查用户名是否可用
	 * @param ename
	 * @return
	 */
	@RequestMapping("/checkName")
	@ResponseBody
	public Msg checkName(@RequestParam("ename") String ename) {
		// 先判断用户名是否合法
		String nameRegex = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		if (!ename.matches(nameRegex)) {
			return Msg.failure().add("validateName", "用户名必须是2-5位中文或者6-16位英文和数字的组合！");
		}
		// 进行数据库用户名重复性校验
		boolean flag = empService.checkName(ename);
		if (flag) {
			return Msg.success();
		} else {
			return Msg.failure().add("validateName", "用户名已被注册！");
		}
	}
	
	/**
	 * 根据ID查询雇员数据信息（GET请求）
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") int id) {
		Emp emp = empService.getEmp(id);
		return Msg.success().add("emp", emp);
	}

	/**
	 * 前端如果直接发送Ajax=PUT形式请求，封装的Emp数据除路径外，全是null
	 * 原因：Tomcat将请求体中的数据封装一个map，Spring MVC封装POJO类时会把POJO中的每个属性值，通过
	 * request.getParameter获取，此时Ajax发送PUT请求，请求体中的数据request.getParameter是拿不到的，
	 * 是由于Tomcat发现是PUT请求不会封装请求体中的数据为map，只有POST请求才会封装请求体为map
	 * 解决：配置HttpPutFormContentFilter过滤器，即可将请求体中的数据解析包装成一个map、重写request.getParameter方法
	 * 雇员数据信息更新（PUT请求）
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/emp/{empno}", method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateEmp(Emp emp) {
		empService.updateEmp(emp);
		return Msg.success();
	}
	
	/**
	 * 雇员数据信息批量删除（DELETE请求）
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/emp/{ids}", method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmp(@PathVariable("ids") String ids) {
		List<Integer> list = new ArrayList<Integer>();
		String[] result = ids.split("\\|");
		for (String item: result) {
			list.add(Integer.parseInt(item));
		}
 		empService.doRemoveBatch(list);
		return Msg.success();
	}
	
}
