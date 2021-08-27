package com.meli.ElasticJPA.service;

import com.meli.ElasticJPA.model.Article;
import com.meli.ElasticJPA.repository.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService {

   @Autowired
   IArticleRepository iArticleRepository;

   @Override
   public void save(Article article) {
      iArticleRepository.save(article);
   }

   @Override
   public List<Article> findAll() {
      return iArticleRepository.findAllArticle();
   }

   @Override
   public Article findArticleById(Integer id) {
      return iArticleRepository.findById(id).get();
   }

   @Override
   public void delete(Integer id) {
      iArticleRepository.deleteById(id);
   }

   @Override
   public Article editArticle(Article article) {
      return iArticleRepository.save(article);
   }
}
