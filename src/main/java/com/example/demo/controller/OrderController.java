package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Controller
public class OrderController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	// 顧客情報入力画面表示
	@GetMapping("/order")
	public String index() {
		// 画面遷移
		return "customerForm";
	}
	
	// 注文内容確認画面表示
	@PostMapping("/order/confirm")
	public String confirm(
			@RequestParam("name") String name,
			@RequestParam("address") String  address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			Model model) {
		// リクエストパラメータをもとに顧客インスタンスを生成
		Customer customer = new Customer(name, address, tel, email);
		// 生成した顧客インスタンスをスコープに登録
		model.addAttribute("customer", customer);
		// 画面遷移
		return "orderConfirm";
	}
	
	// 注文確定処理
	@PostMapping("/order")
	public String doOrder(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			Model model) {
		// リクエストパラメータをもとに顧客クラスをインスタンス化
		Customer customer = new Customer(name, address, tel, email);
		// 顧客インスタンスを永続化
		customerRepository.save(customer);

		
		// 画面遷移
		return "ordered";
	}
}
