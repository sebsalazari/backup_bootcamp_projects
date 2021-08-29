package com.meli.ObrasLiterariasAPI.repository;

import com.meli.ObrasLiterariasAPI.model.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, Long> {
   @Query("{ \"match_all\": {} }")
   List<LiteraryWork> findAllWorks();

   // --- Consultas API ---
   // Query (1)
   List<LiteraryWork> findLiteraryWorksByAuthorEquals(String author);

   // Query (2)
   List<LiteraryWork> findLiteraryWorksByNameIsLike(String name);

   // Query (3)
   List<LiteraryWork> findLiteraryWorksByTotalPagesGreaterThan(Integer pages);

   // Query (4)
   List<LiteraryWork> findLiteraryWorksByReleaseYearBefore(Integer year);

   // Query (5)
   List<LiteraryWork> findLiteraryWorksByReleaseYearAfter(Integer year);

   // Query (6)
   List<LiteraryWork> findLiteraryWorksByEditorialEquals(String editorial);
}
