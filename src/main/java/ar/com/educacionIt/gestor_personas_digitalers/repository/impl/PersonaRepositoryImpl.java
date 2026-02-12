package ar.com.educacionIt.gestor_personas_digitalers.repository.impl;

import ar.com.educacionIt.gestor_personas_digitalers.repository.PersonaRepository;
import java.util.List;
import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    // ESTADO: ATRIBUTOS;
    private List<Persona> personasList = new ArrayList<>();
    private Long count = 0L;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;

    // CONSTRUCTOR PARAMETRIZADO;

    // GETTERS Y SETTERS;

    // MÉTODOS;
    // FINDALL();
    @Override
    public List<Persona> findAllRepository() {
        return personasList;
    }

    // FINDBY(LONG ID);
    @Override
    public Optional<Persona> findByRepository(Long id){

        for(Persona persona : personasList){
            if(Objects.equals(persona.getId(), id)){
                return Optional.of(persona);
            }
        }
        return Optional.empty();
    }

    // FINDBY(STRING DNI);
    @Override
    public Optional<Persona> findByRepository(String dni){

        for(Persona persona : personasList){
            if(Objects.equals(persona.getDni(), dni)){
                return Optional.of(persona);
            }
        }
        return  Optional.empty();
    }

    // SAVE(PERSONA PERSONA);
    @Override
    public Persona saveRepository(Persona persona){
        count++;
        persona.setId(count);
        personasList.add(persona);
        return persona;
    }

    // DELETEBY(LONG ID);
    @Override
    public boolean deleteByRepository(Long id){
        Optional<Persona> optionalPersona = this.findByRepository(id);

        if(optionalPersona.isPresent()){
            personasList.remove(optionalPersona.get());
            return true;
        }
        return false;
    }

    // MODIFYBY(LONG ID, PERSONA PERSONA);
    @Override
    public Optional<Persona> modifyByRepository(Long id, Persona persona){

        Optional<Persona> optionalPersona = findByRepository(id);

        if(optionalPersona.isPresent()){

            Persona personaModify = optionalPersona.get();

            // PERSONA;
            // NOMBRE -> PERSONA;
            personaModify.setNombre(persona.getNombre());

            // APELLIDO -> PERSONA;
            personaModify.setApellido(persona.getApellido());

            // FECHANACIMIENTO -> PERSONA;
            personaModify.setFechaNacimiento(persona.getFechaNacimiento());

            // DNI -> PERSONA;
            personaModify.setDni(persona.getDni());

            // DIRECCION;
            // CALLE -> DIRECCION;
            personaModify.getDireccion().setCalle(persona.getDireccion().getCalle());

            // CIUDAD -> DIRECCION;
            personaModify.getDireccion().setCiudad(persona.getDireccion().getCiudad());

            // CODIGOPOSTAL -> DIRECCION;
            personaModify.getDireccion().setCodigoPostal(persona.getDireccion().getCodigoPostal());

            // CONTACTO;
            // TELEFONOFIJO -> CONTACTO;
            personaModify.getContacto().setTelefonoFijo(persona.getContacto().getTelefonoFijo());

            // TELEFONOCELULAR -> CONTACTO;
            personaModify.getContacto().setTelefonoCelular(persona.getContacto().getTelefonoCelular());

            // EMAIL -> CONTACTO;
            personaModify.getContacto().setEmail(persona.getContacto().getEmail());
        }

        return optionalPersona;
    }
}
