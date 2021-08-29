package com.meli.ObrasLiterariasAPI.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras")
@Getter
@Setter
public class LiteraryWork {

   @Id
   private Long id;
   private String name;
   private String author;
   private Integer totalPages;
   private String editorial;
   private Integer releaseYear;
}
