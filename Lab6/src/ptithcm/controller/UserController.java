package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptithcm.entity.User;

@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		return "user/index";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("user") User user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(user);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại");
		} finally {
			session.close();
		}
		return "user/insert";
	}

	// UPDATE
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("user") User user, HttpServletRequest request) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setFullname(request.getParameter("fullname"));
			session.update(user);
			t.commit();
			model.addAttribute("message", "Cập nhật thành công");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Cập nhật thất bại");
		} finally {
			session.close();
		}
		return "user/update";
	}

	// Delete
	@RequestMapping("index/{username}")
	public String delete(ModelMap model, @PathVariable("username") String username, RedirectAttributes ra) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {

			User user = (User) session.get(User.class, username);
			session.delete(user);
			t.commit();
			ra.addFlashAttribute("message", "Xoá thành công! ");
		} catch (Exception e) {
			t.rollback();
			ra.addFlashAttribute("message", "Xoá thất bại! ");
		} finally {
			session.close();
		}

		return "redirect:/user/index.htm";
	}
}
