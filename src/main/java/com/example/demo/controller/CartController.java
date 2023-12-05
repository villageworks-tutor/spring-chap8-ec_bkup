package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	
	// カート画面表示
	@GetMapping("/cart")
	public String index() {
		// 画面遷移
		return "cart";
	}
	
}
