package com.damian.testibm.controller;

import com.damian.testibm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private SupplierController supplierController;

	@GetMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {
		return supplierController.supplierList(modelAndView);
	}

}
