package com.meli.MorseSpringTT.controller;

import com.meli.MorseSpringTT.helpers.MorseHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

   @GetMapping("api/morse/{cadena}")
   public String morseTraductor(@PathVariable String cadena) {
      String chain = MorseHelper.toText(cadena);
      return "<h2>La traducción del morse   { " + cadena + " }  a texto es -> " + chain + "</h2>";
   }
}
