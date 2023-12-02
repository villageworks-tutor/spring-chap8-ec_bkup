package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemContoller {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ItemRepository itemRepository;
	
	// 商品一覧表示
	@GetMapping("/items")
	public String index(Model model) {
		// すべてのカテゴリを種痘
		List<Category> categoryList = categoryRepository.findAll();
		// すべての商品を取得
		List<Item> itemList = itemRepository.findAll();
		// 取得したカテゴリリストと取得した商品をスコープに登録
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("itemList", itemList);
		// 画面遷移
		return "items";
	}
}
