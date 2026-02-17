package ar.com.educacionIt.gestor_personas_digitalers.dto;

import ar.com.educacionIt.gestor_personas_digitalers.model.Contacto;
import ar.com.educacionIt.gestor_personas_digitalers.model.Direccion;
import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;
import ar.com.educacionIt.gestor_personas_digitalers.dto.PersonaDTO;

public class PersonaMapper {

    // ENTITY -> DTO;
    public static PersonaDTO toDTO(Persona persona){
        PersonaDTO dto = new PersonaDTO();
        // PERSONA;
        dto.setId(persona.getId()); // ID;
        dto.setNombre(persona.getNombre()); // NOMBRE;
        dto.setApellido(persona.getApellido()); // APELLIDO;
        dto.setFechaNacimiento(persona.getFechaNacimiento()); // FECHANACIMIENTO;
        dto.setEdad(persona.getEdad()); // EDAD;
        dto.setDni(persona.getDni()); // DNI;
        // DIRECCION;
        dto.setCalle(persona.getDireccion().getCalle()); // PERSONA -> DIRECCION ->CALLE;
        dto.setCiudad(persona.getDireccion().getCiudad()); // PERSONA -> DIRECCION -> CIUDAD;
        dto.setCodigoPostal(persona.getDireccion().getCodigoPostal()); // PERSONA -> DIRECCION -> CODIGOPOSTAL;
        // CONTACTO;
        dto.setTelefonoFijo(persona.getContacto().getTelefonoFijo()); // PERSONA -> CONTACTO -> TELEFONOFIJO;
        dto.setTelefonoCelular(persona.getContacto().getTelefonoCelular()); // PERSONA -> CONTACTO -> TELEFONOCELULAR;
        dto.setEmail(persona.getContacto().getEmail()); // PERSONA -> CONTACTO -> EMAIL;

        // RETURN DTO;
        return dto;
    }

    // DTO -> ENTITY;
    public static Persona toEntity(PersonaDTO personaDTO){

        // DIRECCION;
        Direccion direccion = new Direccion(
                personaDTO.getCalle(),
                personaDTO.getCiudad(),
                personaDTO.getCodigoPostal()
        );

        // CONTACTO;
        Contacto contacto = new Contacto(
                personaDTO.getTelefonoFijo(),
                personaDTO.getTelefonoCelular(),
                personaDTO.getEmail()
        );

        // PERSONA;


        // RETURN PERSONA;
        Persona persona = new Persona(
                personaDTO.getNombre(),
                personaDTO.getApellido(),
                personaDTO.getFechaNacimiento(),
                direccion,
                contacto,
                personaDTO.getDni()
        );

        return persona;
    }



}
