package com.meli.ElasticJPA.repository;

import com.meli.ElasticJPA.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleRepository extends ElasticsearchRepository<Article, Integer> {

   // Comillas dobles y sin Query si es personalizada
   @Query("{ \"match_all\": {} }")
   public List<Article> findAllArticle();
}
