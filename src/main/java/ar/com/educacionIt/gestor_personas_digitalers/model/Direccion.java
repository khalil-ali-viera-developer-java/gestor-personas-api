package ar.com.educacionIt.gestor_personas_digitalers.model;

public class Direccion {

    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Direccion(){
    }

    public Direccion(String calle, String ciudad, String codigoPostal){
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle(){
        return this.calle;
    }

    public void setCalle(String calle){
        this.calle = calle;
    }

    public String getCiudad(){
        return this.ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getCodigoPostal(){
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal){
        this.codigoPostal = codigoPostal;
    }
}
