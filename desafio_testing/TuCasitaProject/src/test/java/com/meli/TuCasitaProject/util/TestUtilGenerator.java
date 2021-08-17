package com.meli.TuCasitaProject.util;

import com.meli.TuCasitaProject.model.DistrictDTO;
import com.meli.TuCasitaProject.model.EnvironmentDTO;
import com.meli.TuCasitaProject.model.PropertyDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {

   public static List<PropertyDTO> getProperty() {
      List<PropertyDTO> listProperty = new ArrayList<>();

      PropertyDTO pro1 = new PropertyDTO(123, "Camp House", 50.0, 60.0,
              getDistricts().get(0), getRoom());

      PropertyDTO pro2 = new PropertyDTO(321, "Romareda", 35.0, 45.0,
              getDistricts().get(1), getRoom());

      PropertyDTO pro3 = new PropertyDTO(456, "Parca Sol", 45.0, 35.0,
              getDistricts().get(2), getRoom());

      listProperty.add(pro1);
      listProperty.add(pro2);
      listProperty.add(pro3);

      return listProperty;
   }

   public static List<DistrictDTO> getDistricts() {
      List<DistrictDTO> list = new ArrayList<>();

      DistrictDTO dis1 = new DistrictDTO("Belgrano", 2500, 600);
      DistrictDTO dis2 = new DistrictDTO("Boedo", 3100, 900);
      DistrictDTO dis3 = new DistrictDTO("Macarenitaaa", 1800, 500);

      list.add(dis1);
      list.add(dis2);
      list.add(dis3);

      return list;
   }

   public static List<EnvironmentDTO> getRoom() {
      List<EnvironmentDTO> list = new ArrayList<>();

      EnvironmentDTO env1 = new EnvironmentDTO("Sala", 22, 27);
      EnvironmentDTO env2 = new EnvironmentDTO("Pieza 1", 14, 17);
      EnvironmentDTO env3 = new EnvironmentDTO("Pieza 2", 16, 20);

      list.add(env1);
      list.add(env2);
      list.add(env3);

      return list;
   }

   public static PropertyDTO getPropertyWithInvalidDimensions() {
      PropertyDTO pro = new PropertyDTO(1000, "Campin House", 15.0, 15.0,
              getDistricts().get(0), getRoom());

      return pro;
   }

   public static PropertyDTO getPropertyInvalidPayload () {
      PropertyDTO pro = new PropertyDTO(1000, "club house", -45.0, 90.0,
              getDistricts().get(0), getRoom());

      return pro;
   }

}
