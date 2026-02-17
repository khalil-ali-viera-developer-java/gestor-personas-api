package ar.com.educacionIt.gestor_personas_digitalers.model;

import java.time.LocalDate;
import ar.com.educacionIt.gestor_personas_digitalers.service.UtilidadEdad;

public class Persona {

    // ESTADO: ATRIBUTOS;
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int edad;
    private String dni;
    private Direccion direccion;
    private Contacto contacto;


    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public Persona(){
    }

    // CONSTRUCTOR PARAMETRIZADO;
    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion, Contacto contacto, String dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = UtilidadEdad.calcularEdad(fechaNacimiento);
        this.direccion = direccion;
        this.contacto = contacto;
        this.dni = dni;
    }

    // GETTERS Y SETTERS;
    // ID;
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    // NOMBRE;
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // APELLIDO;
    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    // FECHANACIMIENTO;
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    // EDAD;
    public int getEdad(){
        return this.edad;
    }

    // DNI;
    public String getDni(){
        return this.dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    // DIRECCION;
    public Direccion getDireccion(){
        return this.direccion;
    }

    public void setDireccion(Direccion direccion){
        this.direccion = direccion;
    }

    // CONTACTO;
    public Contacto getContacto(){
        return this.contacto;
    }

    public void setContacto(Contacto contacto){
        this.contacto = contacto;
    }

}
