package com.meli.ElasticJPA.service;

import com.meli.ElasticJPA.model.Article;

import java.util.List;

public interface IArticleService {
   void save(Article article);

   List<Article> findAll();

   Article findArticleById(Integer id);

   void delete(Integer id);

   Article editArticle(Article article);
}
