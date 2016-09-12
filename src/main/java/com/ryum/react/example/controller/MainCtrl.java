package com.ryum.react.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Move Controller
 *  
 * @author ryum
 */
@Controller
public class MainCtrl {

	@RequestMapping("/")
	public String index(ModelMap model) throws Exception {
		return "example/index";
	}

}