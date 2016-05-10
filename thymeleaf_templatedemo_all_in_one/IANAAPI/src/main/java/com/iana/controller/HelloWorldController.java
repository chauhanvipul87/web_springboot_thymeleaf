package com.iana.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iana.model.Customer;
import com.iana.model.Gender;
import com.iana.model.PaymentMethod;
import com.iana.model.Product;

@Controller
public class HelloWorldController {
	
	
	/* http://www.thymeleaf.org/eclipse-plugin-update-site/ */	
	@RequestMapping("/hello")
	public String testHelloWorld(ModelMap model){
		model.addAttribute("msg", "Hi There, Hello World!!!");
		return "index";
	}
	
	 @RequestMapping("/properties")
     @ResponseBody
     java.util.Properties properties() {
        return System.getProperties();
     }
	
	 @RequestMapping("/product_details")
	public String viewProductDetails(ModelMap model){
		Product product  = new Product("Description", 2500 , new Date());
		model.addAttribute("product", product);
		model.addAttribute("html", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
		
		
		
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		
		product  = new Product("Description", 50 , new Date());
		productList.add(product);
		
		product  = new Product("Description", 2500 , new Date());
		productList.add(product);
		productList.add(product);
		
		product  = new Product("Description", 99 , new Date());
		productList.add(product);

		model.addAttribute("productList", productList);
		
		List<Customer> customerList = new ArrayList<>();
		Customer c = new Customer(101, "Vipul", "Chauhan", Gender.MALE, PaymentMethod.BANK_TRANSFER, 2500, ""); 
		customerList.add(c);
		
		c = new Customer(101, "Vinita", "Chauhan", Gender.FEMALE, PaymentMethod.BANK_TRANSFER, 2500, "");
		customerList.add(c);
		
		c = new Customer(101, "Vipul", "Chauhan", Gender.MALE, PaymentMethod.CREDIT_CARD, 250, "");
		customerList.add(c);
		
		c = new Customer(101, "Vaishali", "Chauhan", Gender.FEMALE, PaymentMethod.DIRECT_DEBIT, 15000, "");
		customerList.add(c);
		model.addAttribute("customer", c);
		
		c = new Customer(101, "Vrunda", "Chauhan", Gender.FEMALE, PaymentMethod.BANK_TRANSFER, 2500, "");
		customerList.add(c);
		
		model.addAttribute("customerList", customerList);
		
		List<Gender> genders = new ArrayList<>();
		genders.add(Gender.FEMALE);
		genders.add(Gender.MALE);
		
		
		model.addAttribute("genders", genders);
		
		List<PaymentMethod> paymentMethods = new ArrayList<>();
		paymentMethods.add(PaymentMethod.BANK_TRANSFER);
		paymentMethods.add(PaymentMethod.DIRECT_DEBIT);
		paymentMethods.add(PaymentMethod.CREDIT_CARD);
		
		model.addAttribute("paymentMethods", paymentMethods);
		model.addAttribute("customerName", "Vipul");
		
		
		Map<String,Object> map = new HashMap<>();
		map.put("name", "Vipul");
		map.put("sname", "Chauhan");
		map.put("age", 35);
		
		model.addAttribute("userMap", map);
		
		return "product_details";
	}
	 
	 @RequestMapping("/saveCustomer")
		public String viewProductDetails(ModelMap model,Customer customer,
				BindingResult bindingResult){
		 System.out.println("Customer ::"+customer);
		return "customer_save_success";
		 
	 }
	 
	 @RequestMapping("/appendix-b-expression-utility-objects")
		public String linkingAppendix(ModelMap model){
		return "expression_utility";
		 
	 }
}
