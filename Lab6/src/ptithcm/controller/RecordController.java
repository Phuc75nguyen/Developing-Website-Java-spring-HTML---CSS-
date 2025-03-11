package ptithcm.controller;

import java.util.Date;
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

import ptithcm.entity.Record;
import ptithcm.entity.Staff;
import ptithcm.entity.User;

@Transactional
@Controller
@RequestMapping("record")
public class RecordController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("records", list);
		return "record/index";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("record", new Record());
		return "record/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("record") Record record) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			record.setDate(new Date());
			session.save(record);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thành công");
		} finally {
			session.close();
		}
		return "record/insert";
	}

	@ModelAttribute("staffs")
	public List<Staff> getStaffs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}

	// UPDATE
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ModelMap model) {
		model.addAttribute("record", new Record());
		return "record/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("record") Record record) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(record);
			t.commit();
			model.addAttribute("message", "Cập nhật thành công");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Cập nhật thất bại");
		} finally {
			session.close();
		}
		return "record/update";
	}

	// Delete
	@RequestMapping("index/{id}")
	public String delete(ModelMap model, @PathVariable("id") String id, RedirectAttributes ra) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {

			Record record = (Record) session.get(Record.class, id);
			session.delete(record);
			t.commit();
			ra.addFlashAttribute("message", "Xoá thành công! ");
		} catch (Exception e) {
			t.rollback();
			ra.addFlashAttribute("message", "Xoá thất bại! ");
		} finally {
			session.close();
		}
		return "redirect:/record/index.htm";
	}
}
