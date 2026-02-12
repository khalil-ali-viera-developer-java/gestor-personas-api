package ar.com.educacionIt.gestor_personas_digitalers.repository;

import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository {

    List<Persona> findAllRepository();
    Optional<Persona> findByRepository(Long id);
    Optional<Persona> findByRepository(String dni);
    Persona saveRepository(Persona persona);
    boolean deleteByRepository(Long id);
    Optional<Persona> modifyByRepository(Long id, Persona persona);

}
