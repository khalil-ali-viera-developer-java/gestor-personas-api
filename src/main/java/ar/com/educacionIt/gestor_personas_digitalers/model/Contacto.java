package ar.com.educacionIt.gestor_personas_digitalers.model;

public class Contacto {

    // ESTADO: ATRIBUTOS;
    private String telefonoFijo;
    private String telefonoCelular;
    private String email;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public Contacto(){

    }

    // CONSTRUCTOR PARAMETRIZADO;
    public Contacto(String telefonoFijo, String telefonoCelular, String email){
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.email = email;
    }

    // GETTERS Y SETTERS;
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

}
