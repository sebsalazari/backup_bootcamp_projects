package com.meli.ElasticJPA.repository;

import com.meli.ElasticJPA.model.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {
   @Query("{ \"match_all\": {} }")
   public List<Empleado> findAllEmpleado();

   public List<Empleado> getEmpleadoByAgeEquals(Integer age);

   public List<Empleado> getEmpleadoByNameEquals(String name);

   @Query("{\n" +
           "  \"range\": {\n" +
           "    \"age\": {\n" +
           "      \"gte\": ?0,\n" +
           "      \"lte\": ?1\n" +
           "    }\n" +
           "  }\n" +
           "}")
   public List<Empleado> getEmpleadoByAgeBetween(Integer age1, Integer age2);
}
