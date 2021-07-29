package com.meli.demo1.controller;

import com.meli.demo1.helpers.Romanos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

   @GetMapping("/hello/{number}")
   public String helloWorld(@PathVariable int number) {
      String romano = Romanos.convertToRomano(number);
      return "<h2>El numero <b>" + number + "</b> en romano es -> <b>" + romano + " </b> </h2>";
   }
}
