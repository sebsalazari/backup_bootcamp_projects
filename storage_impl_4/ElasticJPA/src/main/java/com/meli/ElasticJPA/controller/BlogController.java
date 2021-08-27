package com.meli.ElasticJPA.controller;

import com.meli.ElasticJPA.model.Article;
import com.meli.ElasticJPA.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

   @Autowired
   IArticleService iArticleService;

   @PostMapping("/article/new")
   public ResponseEntity<String> saveArticle(@RequestBody Article article) {
      iArticleService.save(article);
      return new ResponseEntity<>("Articulo guardado con exito", HttpStatus.OK);
   }

   @GetMapping("/get-articles")
   public ResponseEntity<List<Article>> getArticles() {
      return new ResponseEntity<>(iArticleService.findAll(), HttpStatus.OK);
   }

   @GetMapping("/get-article/{id}")
   public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
      return new ResponseEntity<>(iArticleService.findArticleById(id), HttpStatus.OK);
   }

   @DeleteMapping("/article/delete/{id}")
   public ResponseEntity<String> deleteArticle(@PathVariable Integer id) {
      iArticleService.delete(id);
      return new ResponseEntity<>("Articulo eliminado con exito", HttpStatus.OK);
   }

   @PutMapping("/article/edit")
   public ResponseEntity<Article> deleteArticle(@RequestBody Article article) {
      return new ResponseEntity<>(iArticleService.editArticle(article), HttpStatus.OK);
   }
}
