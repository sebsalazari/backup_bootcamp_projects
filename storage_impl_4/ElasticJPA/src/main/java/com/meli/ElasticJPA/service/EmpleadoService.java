package com.meli.ElasticJPA.service;

import com.meli.ElasticJPA.model.Empleado;
import com.meli.ElasticJPA.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

   @Autowired
   IEmpleadoRepository iEmpleadoRepository;

   @Override
   public void save(Empleado empleado) {
      iEmpleadoRepository.save(empleado);
   }

   @Override
   public List<Empleado> findAll() {
      return iEmpleadoRepository.findAllEmpleado();
   }

   @Override
   public void delete(Integer id) {
      iEmpleadoRepository.deleteById(id);
   }

   @Override
   public List<Empleado> getListEmpleadosByAge(Integer age) {
      return iEmpleadoRepository.getEmpleadoByAgeEquals(age);
   }

   @Override
   public List<Empleado> getListEmpleadosByName(String name) {
      return iEmpleadoRepository.getEmpleadoByNameEquals(name);
   }

   @Override
   public List<Empleado> getListEmpleadosByRankAge(Integer age1, Integer age2) {
      return iEmpleadoRepository.getEmpleadoByAgeBetween(age1, age2);
   }
}
