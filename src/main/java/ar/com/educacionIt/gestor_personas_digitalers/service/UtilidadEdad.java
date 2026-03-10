package ar.com.educacionIt.gestor_personas_digitalers.service;

import java.time.LocalDate;
import java.time.Period;

public class UtilidadEdad {

    // ESTADO: ATRIBUTOS;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;

    // GETTERS Y SETTERS;

    public static int calcularEdad(LocalDate fechaNacimiento){

        // SI LA FECHA DE NACIMIENTO ES FUTURA;
        if(fechaNacimiento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }

        return Period.between(fechaNacimiento, LocalDate.now()).getYears();

    }

}
