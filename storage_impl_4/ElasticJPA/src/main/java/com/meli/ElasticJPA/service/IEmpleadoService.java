package com.meli.ElasticJPA.service;

import com.meli.ElasticJPA.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
   void save(Empleado empleado);

   List<Empleado> findAll();

   void delete(Integer id);

   // --- Consultas especificas ---
   List<Empleado> getListEmpleadosByAge(Integer age);
   List<Empleado> getListEmpleadosByName(String name);
   List<Empleado> getListEmpleadosByRankAge(Integer age1, Integer age2);
}

