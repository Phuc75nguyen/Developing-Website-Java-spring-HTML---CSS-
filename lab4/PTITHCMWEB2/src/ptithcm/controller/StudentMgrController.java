package ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.bean.Student;

@Controller
@RequestMapping(value="student-mgr.htm")
public class StudentMgrController {
	@RequestMapping()
	public String index(ModelMap model) {
		model.addAttribute("message","Bạn gọi index()");
		return "student-mgr";
	}
	@RequestMapping(params="btnInsert")
	public String insert(ModelMap model, 
		@RequestParam("name") String name,
		@RequestParam("mark") Double mark,
		@RequestParam("major") String major)
	
	{
		System.out.println("happen");
		model.addAttribute("name",name);
		model.addAttribute("mark",mark);
		model.addAttribute("major",major);
		return "success";
	}
	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, Student student) {
		model.addAttribute("student",student);
		return "success2";
	}
	@RequestMapping(params="btnDelete")
	public String delete(ModelMap model) {
		model.addAttribute("message", "Bạn gọi delete()");
		return "student-mgr";
	}
	@RequestMapping(params="InkEdit")
	public String edit(ModelMap model) {
		model.addAttribute("message", "Bạn gọi edit()");
		return "student-mgr";
	}
}

