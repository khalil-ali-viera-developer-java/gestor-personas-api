package ar.com.educacionIt.gestor_personas_digitalers.service.impl;

import ar.com.educacionIt.gestor_personas_digitalers.exception.PersonaNotFoundException;
import ar.com.educacionIt.gestor_personas_digitalers.service.PersonaService;
import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.educacionIt.gestor_personas_digitalers.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    // ESTADO: ATRIBUTOS;
    private PersonaRepository personaRepository;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;

    // CONSTRUCTOR PARAMETRIZADO;
    public PersonaServiceImpl(@Autowired PersonaRepository personaRepository)
    {
        this.personaRepository = personaRepository;
    }

    // FINDBY(LONG ID);
    @Override
    public Persona findByService(Long id) throws PersonaNotFoundException {

        // VALIDACIÓN;
        // ID;
        if(id == null){
            throw new IllegalArgumentException("El id de la persona no puede ser nulo");
        }

        if(id <= 0L){
            throw new IllegalArgumentException("El id de la persona no puede ser 0 ni negativo");
        }

        Optional<Persona> personaOptional = personaRepository.findByRepository(id);

        if (personaOptional.isEmpty()) {
            throw new PersonaNotFoundException("Persona con id " + id + " no encontrada");
        }

        return personaOptional.get();
    }

    // FINDBY(STRING DNI);
    @Override
    public Persona findByService(String dni) throws PersonaNotFoundException{
        // VALIDACIÓN;
        // DNI;
        if(dni == null){
            throw new IllegalArgumentException("El dni de la persona no puede ser nulo");
        }

        if(dni.isBlank()){
            throw new IllegalArgumentException("El dni de la persona no puede estar vacio, tener espacios en blanco o tener caracteres de espacios en blanco");
        }

        if(!dni.matches("\\d{8}")){
            throw new IllegalArgumentException("El dni de la persona tiene que tener exactamente 8 números");
        }

        Optional<Persona> optionalPersona = this.personaRepository.findByRepository(dni);

        if(optionalPersona.isEmpty()){
            throw new PersonaNotFoundException("La persona con el dni " + dni + " no encontrada");
        }

        return optionalPersona.get();

    }



    // FINDALL();
    @Override
    public List<Persona> findAllService() {
        return this.personaRepository.findAllRepository();
    }

    // SAVE(PERSONA PERSONA);
    @Override
    public Persona saveService(Persona persona) {

        // VALIDACIÓN;
        // PERSONA;
        if(persona == null){
            throw new IllegalArgumentException("Persona no puede ser nula");
        }

        // PERSONA -> NOMBRE;
        if(persona.getNombre() == null){
            throw new IllegalArgumentException("El nombre de la persona no puede ser nulo");
        }

        if(persona.getNombre().isBlank()){
            throw new IllegalArgumentException("El nombre de la persona no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        // PERSONA -> APELLIDO;
        if(persona.getApellido() == null){
            throw new IllegalArgumentException("El apellido de la persona no puedo ser nulo");
        }

        if(persona.getApellido().isBlank()){
            throw new IllegalArgumentException("El apellido de la persona no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        // PERSONA -> FECHANACIMIENTO;
        if(persona.getFechaNacimiento() == null){
            throw new IllegalArgumentException("La fecha de nacimiento de la persona no puede ser nula");
        }

        // PERSONA -> DIRECCION;
        if(persona.getDireccion() == null){
            throw new IllegalArgumentException("La dirección de la persona no puede ser nula");
        }

        // PERSONA -> DIRECCION -> CALLE;
        if(persona.getDireccion().getCalle() == null){
            throw new IllegalArgumentException("La calle de la persona no puede ser nula");
        }

        if(persona.getDireccion().getCalle().isBlank()){
            throw new IllegalArgumentException("La calle de la persona no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        // PERSONA -> DIRECCION -> CIUDAD;
        if(persona.getDireccion().getCiudad() == null){
            throw new IllegalArgumentException("La ciudad de la persona no puede ser nula");
        }

        if(persona.getDireccion().getCiudad().isBlank()){
            throw new IllegalArgumentException("La ciudad de la persona no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        // PERSONA -> DIRECCION -> CODIGOPOSTAL;
        if(persona.getDireccion().getCodigoPostal() == null){
            throw new IllegalArgumentException("El código postal de la persona no puede nulo");
        }

        if(persona.getDireccion().getCodigoPostal().isBlank()){
            throw new IllegalArgumentException("El código postal de la persona no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        if(!persona.getDireccion().getCodigoPostal().matches("\\d{4}")){
            throw new IllegalArgumentException("El código postal debe tener exactamente 4 números");
        }

        return this.personaRepository.saveRepository(persona);
    }

    // DELETEBY(LONG ID);
    @Override
    public void deleteByService(Long id) throws PersonaNotFoundException{
        // VALIDACIÓN;
        // ID;
        if(id == null){
            throw new IllegalArgumentException("El id de la persona no puede nulo");
        }

        if(id <= 0){
            throw new IllegalArgumentException("El id de la persona no puede ser 0 ni negativo");
        }

       boolean deleteService = this.personaRepository.deleteByRepository(id);

       if(!deleteService){
           throw new PersonaNotFoundException("La persona con el id " + id + " no fue encontrada");
       }
    }

    // MODIFYBY(LONG ID , PERSONA PERSONA);
    @Override
    public Persona modifyByService(Long id, Persona persona) throws PersonaNotFoundException{
        // VALIDACION;
        // ID;
        if(id == null){
            throw new IllegalArgumentException("El id de la persona no puede ser nulo");
        }

        if(id <= 0){
            throw new IllegalArgumentException("El id de la persona no puede ser 0 ni negativo");
        }

        // PERSONA;
        if(persona == null){
            throw new IllegalArgumentException("Persona no puede ser nulo");
        }

        // PERSONA -> NOMBRE;
        if(persona.getNombre() == null){
            throw new IllegalArgumentException("El nombre de la persona no puede ser nulo");
        }

        if(persona.getNombre().isBlank()){
            throw new IllegalArgumentException("El nombre de la persona no puede estar vacio, tener espacios blancos o tener caracteres de espacios en blanco");
        }

        // PERSONA -> APELLIDO;
        if(persona.getApellido() == null){
            throw new IllegalArgumentException("El apellido de la persona no puede ser nulo");
        }

        if(persona.getApellido().isBlank()){
            throw new IllegalArgumentException("El apellido de la persona no puede estar vacio, tener espacios en blancos o tener caracteres de espacios en blanco");
        }

        // PERSONA -> FECHANACIMIENTO;
        if(persona.getFechaNacimiento() == null){
            throw new IllegalArgumentException("La fecha de nacimiento de la persona no puede ser nulo");
        }

        // DIRECCION;
        if(persona.getDireccion() == null){
            throw new IllegalArgumentException("La direccion de la persona no puede ser nulo");
        }

        // DIRECCION -> CALLE;
        if(persona.getDireccion().getCalle() == null){
            throw new IllegalArgumentException("La calle de la dirección no puede ser nula");
        }

        if(persona.getDireccion().getCalle().isBlank()){
            throw new IllegalArgumentException("La calle de la dirección no puede estar vacia, tener espacios en blancos o tener caracteres de espacios en blanco");
        }

        // DIRECCION -> CIUDAD;
        if(persona.getDireccion().getCiudad() == null){
            throw new IllegalArgumentException("La ciudad de la dirección no puede ser nulo");
        }

        if(persona.getDireccion().getCiudad().isBlank()){
            throw new IllegalArgumentException("La ciudad de la dirección no puede estar vacia, tener espacios en blancos o tener caracteres de espacios en blanco ");
        }

        // DIRECCION -> CODIGOPOSTAL;
        if(persona.getDireccion().getCodigoPostal() == null){
            throw new IllegalArgumentException("El código postal de la dirección no puede ser nulo");
        }

        if(persona.getDireccion().getCodigoPostal().isBlank()){
            throw new IllegalArgumentException("El código postal de la dirección no puede estar vacio, tener espacios en blancos o tener caracteres de espacios en blanco");
        }

        // CONTACTO;
        if(persona.getContacto() == null){
            throw new IllegalArgumentException("El contacto de la persona no puede ser nulo");
        }

        // CONTACTO -> TELEFONOFIJO;
        if(persona.getContacto().getTelefonoFijo() == null){
            throw new IllegalArgumentException("El teléfono fijo del contacto no puede ser nulo");
        }

        if(persona.getContacto().getTelefonoFijo().isBlank()){
            throw new IllegalArgumentException("El teléfono fijo del contacto no puede estar vacio, tener espacios en blanco o tener caracteres de espacios en blancos");
        }

        // CONTACTO -> TELEFONOCELULAR;
        if(persona.getContacto().getTelefonoCelular() == null){
            throw new IllegalArgumentException("El telefono del contacto no puede ser nulo");
        }

        if(persona.getContacto().getTelefonoCelular().isBlank()){
            throw new IllegalArgumentException("El teléfono del contacto no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        // CONTACTO -> EMAIL;
        if(persona.getContacto().getEmail() == null){
            throw new IllegalArgumentException("El email del contacto no puede ser nulo");
        }

        if(persona.getContacto().getEmail().isBlank()){
            throw new IllegalArgumentException("El email del contacto no puede estar vacio, tener espacios en blanco o caracteres de espacios en blanco");
        }

        Optional<Persona> optionalPersona = this.personaRepository.modifyByRepository(id, persona);
        if(optionalPersona.isEmpty()){
            throw new PersonaNotFoundException("La persona con el id " + id + " no fue encontrada");
        }

        Persona people = optionalPersona.get();
        return people;

    }

}
