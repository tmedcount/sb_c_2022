package com.khs.exam.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.khs.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
		// INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, `body` = ?;
		public Article writeArticle(String title, String body);
		
		// SELECT * FROM article WHERE id = ?;
		@Select("SELECT * FROM article WHERE id = #{id}")
		public Article getArticle(@Param("id") int id);
		
		// DELETE FROM article WHERE id = ?;
		@Delete("DELETE FROM article WHERE id = #{id}")
		public void deleteArticle(@Param("id") int id);
		
		// UPDATE article SET updateDate = NOW(), title = ?, `body` = ? WHERE id = ?;
		@Update("UPDATE article SET updateDate = NOW(), title = #{title}, `body` = #{body} WHERE id = #{id}")
		public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
		
		// SELECT * FROM article ORDER BY id DESC;
		@Select("SELECT * FROM article ORDER BY id DESC")
		public List<Article> getArticles();
}
