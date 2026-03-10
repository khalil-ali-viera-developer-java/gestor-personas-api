package ar.com.educacionIt.gestor_personas_digitalers.dto;

import java.time.LocalDate;

public class PersonaRequestDTO {

    // ESTADO: ATRIBUTOS;
    // PERSONA;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String dni;
    // CONTACTO;
    private String telefonoFijo;
    private String telefonoCelular;
    private String email;
    // DIRECCION;
    private String calle;
    private String ciudad;
    private String codigoPostal;


    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public PersonaRequestDTO(){

    }

    // CONSTRUCTOR PARAMETRIZADO;

    // GETTERS Y SETTERS;
    // PERSONA;
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

    // DNI;
    public String getDni(){
        return this.dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    // CONTACTO;
    // TELEFONOFIJO;
    public String getTelefonoFijo(){
        return this.telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo){
        this.telefonoFijo = telefonoFijo;
    }

    // TELEFONOCELULAR;
    public String getTelefonoCelular(){
        return this.telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular){
        this.telefonoCelular = telefonoCelular;
    }

    // EMAIL;
     public String getEmail(){
        return this.email;
     }

     public void setEmail(String email){
        this.email = email;
     }

    // DIRECCION;
    // CALLE;
    public String getCalle(){
        return this.calle;
    }

    public void setCalle(String calle){
        this.calle = calle;
    }

    // CIUDAD;
    public String getCiudad(){
        return this.ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    // CODIGOPOSTAL;
    public String getCodigoPostal(){
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal){
        this.codigoPostal = codigoPostal;
    }

    // MÉTODOS;
}
