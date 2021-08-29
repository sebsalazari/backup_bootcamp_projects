package com.meli.ObrasLiterariasAPI.service;

import com.meli.ObrasLiterariasAPI.model.LiteraryWork;
import com.meli.ObrasLiterariasAPI.repository.ILiteraryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkService implements ILiteraryWorkService {

   @Autowired
   ILiteraryWorkRepository iLiteraryWorkRepository;

   @Override
   public void saveLiteraryWork(LiteraryWork literaryWork) {
      iLiteraryWorkRepository.save(literaryWork);
   }

   @Override
   public void deleteLiteraryWork(Long id) {
      iLiteraryWorkRepository.deleteById(id);
   }

   @Override
   public List<LiteraryWork> getListLiteraryWorks() {
      return iLiteraryWorkRepository.findAllWorks();
   }

   // --- Queries ---
   @Override
   public List<LiteraryWork> getListLiteraryWorksByAuthorName(String author) {
      return iLiteraryWorkRepository.findLiteraryWorksByAuthorEquals(author);
   }

   @Override
   public List<LiteraryWork> getListLiteraryWorksByName(String name) {
      return iLiteraryWorkRepository.findLiteraryWorksByNameIsLike(name);
   }

   @Override
   public List<LiteraryWork> getListLiteraryWorksByNumberPages(Integer pages) {
      return iLiteraryWorkRepository.findLiteraryWorksByTotalPagesGreaterThan(pages);
   }

   @Override
   public List<LiteraryWork> getListLiteraryWorksByYearBefore(Integer year) {
      return iLiteraryWorkRepository.findLiteraryWorksByReleaseYearBefore(year);
   }

   @Override
   public List<LiteraryWork> getListLiteraryWorksByYearAfter(Integer year) {
      return iLiteraryWorkRepository.findLiteraryWorksByReleaseYearAfter(year);
   }

   @Override
   public List<LiteraryWork> getListLiteraryWorksByEditorial(String editorial) {
      return iLiteraryWorkRepository.findLiteraryWorksByEditorialEquals(editorial);
   }
}
