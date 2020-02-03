package com.test.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public ModelAndView home() {
		List<Customer> list = customerService.listAll();
		System.out.println("action home");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listCustomer", list);
		return mv;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		System.out.println("action new");
		Customer customer = new Customer();
		model.put("customer", customer);
		return "new_customer";
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("action save");
		System.out.println("---- save name:"+ customer.getName());
		customerService.save(customer);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam Long id) {
		System.out.println("action edit");
		Customer customer = customerService.get(id);
		ModelAndView mv = new ModelAndView("edit_customer");
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam Long id) {
		System.out.println("action delete");
		customerService.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		System.out.println("action search");
		List<Customer> result = customerService.search(keyword);
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("result", result);
		return mv;
	}
}
