package ar.com.educacionIt.gestor_personas_digitalers.service;

import ar.com.educacionIt.gestor_personas_digitalers.exception.PersonaNotFoundException;
import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;
import java.util.List;

public interface PersonaService {

    List<Persona> findAllService();
    Persona findByService(Long id) throws PersonaNotFoundException;
    Persona findByService(String dni) throws PersonaNotFoundException;
    Persona saveService(Persona persona);
    void deleteByService(Long id) throws PersonaNotFoundException;
    Persona modifyByService(Long id, Persona persona) throws PersonaNotFoundException;
}
