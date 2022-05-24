package com.khs.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UsrHomeController {
	@RequestMapping("usr/home/getString")
	@ResponseBody
	public String getString() {
		return "Hi";
	}
	
	@RequestMapping("usr/home/getInt")
	@ResponseBody
	public int getInt() {
		return 10;
	}
	
	@RequestMapping("usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		return 10.5f;
	}
	
	@RequestMapping("usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
		return 10.5;
	}
	
	@RequestMapping("usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		return true;
	}
	
	@RequestMapping("usr/home/getCharacter")
	@ResponseBody
	public char getCharacter() {
		return 'a';
	}
	
	@RequestMapping("usr/home/getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("철수 나이", 10);
		map.put("영희 나이", 20);
	
		return map;
	}
	
	@RequestMapping("usr/home/getList")
	@ResponseBody
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("철수");
		list.add("영희");
		
		return list;
	}
	
	@RequestMapping("usr/home/getArticle")
	@ResponseBody
	public Article getArticle() {
		Article article = new Article(1, "제목1");
		
		return article;
	}
	
	@RequestMapping("usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article(1, "제목1"));
		articles.add(new Article(2, "제목2"));
				
		return articles;
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Article {
	private int id;
	private String title; 
}
