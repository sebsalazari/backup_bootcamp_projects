package com.meli.ElasticJPA.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "empleado")
@Getter
@Setter
public class Empleado {
   @Id
   private Integer id;
   private String name;
   private Integer age;

   @Field(type = FieldType.Nested, includeInParent = true)
   private City city;
}
