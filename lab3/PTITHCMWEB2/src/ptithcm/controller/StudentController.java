package ptithcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.bean.majors;
import ptithcm.bean.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("index")
	public String index(ModelMap model) {
		Student student = new Student("Nguyễn Văn Thu", 9.5, "WEB");
		model.addAttribute("student", student);
		return "student2";
	}

//	@ModelAttribute("majors")
//	public Map<String, String> getMajors() {
//		Map<String, String> mj = new HashMap<>();
//		mj.put("IT", "Information Technology");
//		mj.put("ML", "Machine Learning");
//		mj.put("IOS", "iPhone Operating System");
//		return mj;
//
//	}

	@ModelAttribute("majors")
	public List<majors> getMajors() {
		List<majors> majors = new ArrayList<>();
		majors.add(new majors("APP", "Ứng dụng phần mềm"));
		majors.add(new majors("ML", " Machine Learning"));
		return majors;
	}

//	@RequestMapping (value = "/student", method = RequestMethod.GET )
//	public String showForm() {
//		return "student/form";
//	}
//	
//	@RequestMapping(value="/student", method=RequestMethod.POST)
//	public String saveData(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String mark = request.getParameter("mark");
//		String major = request.getParameter("major");
//		
//		request.setAttribute("name", name);
//		request.setAttribute("mark", mark);
//		request.setAttribute("major", major);
//		return "student/success";
//	}
//	

}
