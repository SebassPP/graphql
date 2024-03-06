package com.example.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerGraphql {

    List<Estudiante> estudiantes = new ArrayList<>();
    Carrera informatica = new Carrera("Ingenieria Informatica", "Ingenieria", 9, "Jenny");

    public ControllerGraphql() {
        estudiantes.add(new Estudiante(1, "Juan", "Parrado", null, informatica, List.of("Matematicas", "Fisica")));
        estudiantes.add(new Estudiante(2, "Maria", "Lopez", 25, informatica, List.of("Matematicas", "Fisica")));
    }



    @QueryMapping
    public Estudiante consultarEstudiante(@Argument Integer codigoEstudiante) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equals(codigoEstudiante)) {
                return estudiante;
            }
        }
        return null;
    }

    @QueryMapping
    public List<Estudiante> consiltarEstudiantesPorCarrera(@Argument String nombreCarrera) {
        List<Estudiante> resultEstudiantes = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCarrera().nombre().equals(nombreCarrera)) {
                resultEstudiantes.add(estudiante);
            }
            return resultEstudiantes;
        }
        return null;
    }
}
