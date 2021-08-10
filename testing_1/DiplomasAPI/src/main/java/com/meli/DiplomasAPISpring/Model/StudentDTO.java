package com.meli.DiplomasAPISpring.Model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {

   @NotNull(message = "El nombre es obligatorio")
   @NotEmpty(message = "El nombre del alumno no puede estar vacío")
   @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre del alumno debe comenzar con mayúscula")
   @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
   private String studentName;

   @NotNull(message = "Subjects es obligatorio")
   @NotEmpty(message = "La lista no puede estar vacia")
   private List<@Valid SubjectDTO> subjects;

}

