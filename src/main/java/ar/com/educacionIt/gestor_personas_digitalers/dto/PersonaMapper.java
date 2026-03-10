package ar.com.educacionIt.gestor_personas_digitalers.dto;

import ar.com.educacionIt.gestor_personas_digitalers.model.Contacto;
import ar.com.educacionIt.gestor_personas_digitalers.model.Direccion;
import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;

public class PersonaMapper {

    // ENTITY -> DTO;
    public static PersonaResponseDTO toDTO(Persona persona){
        PersonaResponseDTO dto = new PersonaResponseDTO();
        // PERSONA;
        dto.setId(persona.getId()); // ID;
        dto.setNombre(persona.getNombre()); // NOMBRE;
        dto.setApellido(persona.getApellido()); // APELLIDO;
        dto.setFechaNacimiento(persona.getFechaNacimiento()); // FECHANACIMIENTO;
        dto.setEdad(persona.getEdad()); // EDAD;
        dto.setDni(persona.getDni()); // DNI;
        // CONTACTO;
        dto.setTelefonoFijo(persona.getContacto().getTelefonoFijo()); // PERSONA -> CONTACTO -> TELEFONOFIJO;
        dto.setTelefonoCelular(persona.getContacto().getTelefonoCelular()); // PERSONA -> CONTACTO -> TELEFONOCELULAR;
        dto.setEmail(persona.getContacto().getEmail()); // PERSONA -> CONTACTO -> EMAIL;
        // DIRECCION;
        dto.setCalle(persona.getDireccion().getCalle()); // PERSONA -> DIRECCION ->CALLE;
        dto.setCiudad(persona.getDireccion().getCiudad()); // PERSONA -> DIRECCION -> CIUDAD;
        dto.setCodigoPostal(persona.getDireccion().getCodigoPostal()); // PERSONA -> DIRECCION -> CODIGOPOSTAL;

        // RETURN DTO;
        return dto;
    }

    // DTO -> ENTITY;
    public static Persona toEntity(PersonaRequestDTO personaRequestDTO){

        // DIRECCION;
        Direccion direccion = new Direccion(
                personaRequestDTO.getCalle(),
                personaRequestDTO.getCiudad(),
                personaRequestDTO.getCodigoPostal()
        );

        // CONTACTO;
        Contacto contacto = new Contacto(
                personaRequestDTO.getTelefonoFijo(),
                personaRequestDTO.getTelefonoCelular(),
                personaRequestDTO.getEmail()
        );

        // PERSONA;
        Persona persona = new Persona(
                personaRequestDTO.getNombre(),
                personaRequestDTO.getApellido(),
                personaRequestDTO.getFechaNacimiento(),
                direccion,
                contacto,
                personaRequestDTO.getDni()
        );

        // RETURN PERSONA;
        return persona;
    }



}
