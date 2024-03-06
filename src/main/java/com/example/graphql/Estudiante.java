package com.example.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Estudiante {
    private Integer id;
private String nombre;
private String apellido;
private Integer porcentajeBeca;
private Carrera carrera;
private List<String> materiasCursadas;

}
