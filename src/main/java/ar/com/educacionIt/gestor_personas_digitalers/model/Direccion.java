package ar.com.educacionIt.gestor_personas_digitalers.model;

public class Direccion {

    // ESTADO: ATRIBUTOS;
    private String calle;
    private String ciudad;
    private String codigoPostal;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;
    public Direccion(){
    }

    // CONSTRUCTOR PARAMETRIZADO;
    public Direccion(String calle, String ciudad, String codigoPostal){
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    // GETTERS Y SETTERS;
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
}
