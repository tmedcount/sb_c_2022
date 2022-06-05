package com.khs.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khs.exam.demo.service.ArticleService;
import com.khs.exam.demo.util.Ut;
import com.khs.exam.demo.vo.Article;
import com.khs.exam.demo.vo.ResultData;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;
	
	// 액션 메서드 시작
	@RequestMapping("usr/article/doAdd")
	@ResponseBody
	public String doAdd(String title, String body) {
		int id = articleService.writeArticle(title, body);
		
		Article article = articleService.getArticle(id);
		
		return article.getId() + "번 게시물을 생성하였습니다.";
	}
	
	@RequestMapping("usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
	
	@RequestMapping("usr/article/getArticle")
	@ResponseBody
	public ResultData getArticleAction(int id) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}
		
		return ResultData.from("S-1", Ut.f("%d번 게시물입니다.", id), article);
	}
		
	@RequestMapping("usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		articleService.modifyArticle(id, title, body);
		
		return id + "번 게시물을 수정하였습니다.";
	}
	
	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		articleService.deleteArticle(id);
		
		return id + "번 게시물을 삭제하였습니다.";
	}
	// 액션 메서드 끝
}
