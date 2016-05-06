package com.iana.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "product_details";
	}
	 
}
