package com.meli.DiplomasAPISpring.Service;

import com.meli.DiplomasAPISpring.Model.DiplomaDTO;
import com.meli.DiplomasAPISpring.Model.StudentDTO;

public interface IDiplomaService {
   DiplomaDTO createDiploma (StudentDTO studentDTO);
}
