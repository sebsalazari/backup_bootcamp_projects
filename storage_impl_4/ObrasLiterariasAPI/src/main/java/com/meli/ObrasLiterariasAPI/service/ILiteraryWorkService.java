package com.meli.ObrasLiterariasAPI.service;

import com.meli.ObrasLiterariasAPI.model.LiteraryWork;

import java.util.List;

public interface ILiteraryWorkService {
   void saveLiteraryWork(LiteraryWork literaryWork);

   void deleteLiteraryWork(Long id);

   List<LiteraryWork> getListLiteraryWorks();

   // Queries - API
   List<LiteraryWork> getListLiteraryWorksByAuthorName(String author);

   List<LiteraryWork> getListLiteraryWorksByName(String name);

   List<LiteraryWork> getListLiteraryWorksByNumberPages(Integer pages);

   List<LiteraryWork> getListLiteraryWorksByYearBefore(Integer year);

   List<LiteraryWork> getListLiteraryWorksByYearAfter(Integer year);

   List<LiteraryWork> getListLiteraryWorksByEditorial(String editorial);
}
