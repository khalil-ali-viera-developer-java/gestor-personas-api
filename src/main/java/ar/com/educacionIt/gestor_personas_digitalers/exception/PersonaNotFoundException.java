package ar.com.educacionIt.gestor_personas_digitalers.exception;

public class PersonaNotFoundException extends Exception{

    public PersonaNotFoundException() {
    }

    public PersonaNotFoundException(String message) {
        super(message);
    }
}
