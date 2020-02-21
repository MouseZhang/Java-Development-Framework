package cn.ustb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ustb.service.DeptService;
import cn.ustb.vo.Dept;
import cn.ustb.vo.Msg;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts() {
		List<Dept> depts = deptService.getDepts();
		return Msg.success().add("depts", depts);
	}
}
