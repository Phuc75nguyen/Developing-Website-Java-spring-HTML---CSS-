package ptithcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.bean.majors;
import ptithcm.bean.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	ServletContext application;
	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpSession session) {
		
		application.setAttribute("name","Huỳnh Trung Trụ");
		application.setAttribute("level", 2);
		
		
		session.setAttribute("name", "Phan Quang Công");
		session.setAttribute("level",4 );
	
		
		request.setAttribute("name", "Nguyễn Bá Hoàng");
		request.setAttribute("level", 3);
		
		
		session.setAttribute("salary", 1000);
		request.setAttribute("photo", "images/ptithcm-sv.jpg");
		
		return "student/bai1";
	}
	
	@RequestMapping("index2")
	public String index2(ModelMap model) {
		Student sv1 = new Student("Phạm Minh Tuấn", 5.5, "Ứng dụng phần mềm");
		Student sv2 = new Student("Nguyễn Thị Kiều Oanh", 9.5, "Thiết kế Trang Web");
		Student sv3 = new Student("Nguyễn Tấn Tới", 3.5, "Thiết kế Web");
		
		List <Student> list = new ArrayList <>();
		list.add(sv2);
		list.add(sv3);
		
		Map <String, Student> map = new HashMap <>();
		map.put("OangNTk", sv2);
		map.put("ToiNT", sv3);
		
		
		model.addAttribute("bean", sv1);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		
		return "student/index2";
	}
	
//	@RequestMapping("index")
//	public String index(ModelMap model) {
//		Student student = new Student("Nguyễn Văn Thu", 9.5, "WEB");
//		model.addAttribute("student", student);
//		return "student2";
//	}

//	@ModelAttribute("majors")
//	public Map<String, String> getMajors() {
//		Map<String, String> mj = new HashMap<>();
//		mj.put("IT", "Information Technology");
//		mj.put("ML", "Machine Learning");
//		mj.put("IOS", "iPhone Operating System");
//		return mj;
//
//	}

//	@ModelAttribute("majors")
//	public List<majors> getMajors() {
//		List<majors> majors = new ArrayList<>();
//		majors.add(new majors("APP", "Ứng dụng phần mềm"));
//		majors.add(new majors("ML", " Machine Learning"));
//		return majors;
//	}

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
