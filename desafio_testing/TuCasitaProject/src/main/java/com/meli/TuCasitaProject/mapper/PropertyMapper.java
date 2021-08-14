package com.meli.TuCasitaProject.mapper;

import com.meli.TuCasitaProject.model.EnvironmentDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.BiggestEnvironmentDTO;
import com.meli.TuCasitaProject.model.response.PropertyValueDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PropertyMapper {

   public static RegisteredPropertyDTO registerPropertyDTO(PropertyDTO p) {
      return new RegisteredPropertyDTO(p.getProperty_id(), "Successful registration - " +
              "with the id_property you can make the other queries");
   }

   public static PropertyValueDTO valueTotalPropertyDTO(PropertyDTO p, double value) {
      return new PropertyValueDTO(p.getProp_name(), p.getDistrict().getDistrict_name(), value);
   }

   public static BiggestEnvironmentDTO biggerRoomPropertyDTO(EnvironmentDTO e) {
      return new BiggestEnvironmentDTO(e.getRoom_name(), (e.getRoom_length() * e.getRoom_width()));
   }

   public static List<BiggestEnvironmentDTO> listMetersRoomDTO(List<EnvironmentDTO> list) {
      return list.stream().map(e -> new BiggestEnvironmentDTO(e.getRoom_name(), (e.getRoom_length() * e.getRoom_width())))
              .collect(Collectors.toList());
   }
}
