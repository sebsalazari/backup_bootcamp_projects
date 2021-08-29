package com.meli.ObrasLiterariasAPI.controller;

import com.meli.ObrasLiterariasAPI.model.LiteraryWork;
import com.meli.ObrasLiterariasAPI.service.ILiteraryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("literary")
public class LiteraryWorkController {

   @Autowired
   ILiteraryWorkService iLiteraryWorkService;

   @PostMapping("/save")
   public ResponseEntity<String> saveWork(@RequestBody LiteraryWork literaryWork) {
      iLiteraryWorkService.saveLiteraryWork(literaryWork);
      return new ResponseEntity<>("Obra guardada correctamente", HttpStatus.CREATED);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteWork(@PathVariable Long id) {
      iLiteraryWorkService.deleteLiteraryWork(id);
      return new ResponseEntity<>("Obra eliminada correctamente", HttpStatus.OK);
   }

   @GetMapping("/findAll")
   public ResponseEntity<List<LiteraryWork>> findAllWorks() {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorks(), HttpStatus.OK);
   }

   // --- Queries ---
   @GetMapping("/author/name")
   public ResponseEntity<List<LiteraryWork>> findAllWorksByAuthor(@RequestParam String author) {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorksByAuthorName(author), HttpStatus.OK);
   }

   @GetMapping("/name")
   public ResponseEntity<List<LiteraryWork>> findAllWorksByName(@RequestParam String name) {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorksByName(name), HttpStatus.OK);
   }

   @GetMapping("/pages/number/{pages}")
   public ResponseEntity<List<LiteraryWork>> findAllWorksByAuthor(@PathVariable Integer pages) {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorksByNumberPages(pages), HttpStatus.OK);
   }

   @GetMapping("/release/before/{year}")
   public ResponseEntity<List<LiteraryWork>> findAllWorksByReleaseBefore(@PathVariable Integer year) {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorksByYearBefore(year), HttpStatus.OK);
   }

   @GetMapping("/release/after/{year}")
   public ResponseEntity<List<LiteraryWork>> findAllWorksByReleaseAfter(@PathVariable Integer year) {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorksByYearAfter(year), HttpStatus.OK);
   }

   @GetMapping("/editorial/{editorial}")
   public ResponseEntity<List<LiteraryWork>> findAllWorksByEditorial(@PathVariable String editorial) {
      return new ResponseEntity<>(iLiteraryWorkService.getListLiteraryWorksByEditorial(editorial), HttpStatus.OK);
   }
}
