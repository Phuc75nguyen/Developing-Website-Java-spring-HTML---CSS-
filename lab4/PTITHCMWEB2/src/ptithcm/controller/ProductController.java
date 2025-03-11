package ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ptithcm.bean.Product;

@Controller
@RequestMapping ("product")
public class ProductController {
	@RequestMapping("list")
	public String list(ModelMap model) {
		List<Product> list = new ArrayList <>();
		list.add(new Product("Sony Xperia One Mark 5", 1200.0, 0.05));
		list.add(new Product("Iphone 15pro", 1600.0, 0.1));
		list.add(new Product("Samsung Galaxy S24ultra AI", 1600.0, 0.15));
		list.add(new Product("Xiaomi Mi 15 pro", 1400.0, 0.00));
		
		
		model.addAttribute("prods", list);
		return "product/list";
	}

}
