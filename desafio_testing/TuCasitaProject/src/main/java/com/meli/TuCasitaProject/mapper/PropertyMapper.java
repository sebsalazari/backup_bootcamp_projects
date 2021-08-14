package com.meli.TuCasitaProject.mapper;

import com.meli.TuCasitaProject.model.PropertyDTO;
import com.meli.TuCasitaProject.model.response.RegisteredPropertyDTO;

public class PropertyMapper {

   public static RegisteredPropertyDTO registerPropertyDTO(PropertyDTO p) {
      return new RegisteredPropertyDTO(p.getProperty_id(), "Successful registration - " +
              "with the id_property you can make the other queries");
   }

}
