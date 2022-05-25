package com.khs.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khs.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	private int lastArticleId;
	private List<Article> articles;
	
	public UsrArticleController() {
		lastArticleId = 0;
		articles = new ArrayList<>();
		
		makeTestData();
	}
	
	private void makeTestData() {
		for(int i=1; i<=10; i++) {
			int id = lastArticleId + 1;
			String title = "제목" + i;
			String body = "내용" + i;
			
			Article article = new Article(id, title, body);
			
			articles.add(article);
			lastArticleId = id;
		}
	}

	@RequestMapping("usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = lastArticleId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		lastArticleId = id;
				
		return article;
	}
	
	@RequestMapping("usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
	
	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		return id + "번 게시물을 삭제하였습니다.";
	}
}
