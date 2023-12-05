package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
	// 顧客情報入力画面表示
	@GetMapping("/order")
	public String index() {
		// 画面遷移
		return "customerForm";
	}
}
