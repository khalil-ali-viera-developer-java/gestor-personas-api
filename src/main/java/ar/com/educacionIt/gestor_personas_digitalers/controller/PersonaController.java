package ar.com.educacionIt.gestor_personas_digitalers.controller;

import ar.com.educacionIt.gestor_personas_digitalers.dto.PersonaRequestDTO;
import ar.com.educacionIt.gestor_personas_digitalers.exception.PersonaNotFoundException;
import ar.com.educacionIt.gestor_personas_digitalers.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.educacionIt.gestor_personas_digitalers.service.PersonaService;
import ar.com.educacionIt.gestor_personas_digitalers.dto.PersonaResponseDTO;
import ar.com.educacionIt.gestor_personas_digitalers.dto.PersonaMapper;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    // ESTADO: ATRIBUTOS;
    private PersonaService personaService;

    // COMPORTAMIENTO: CONSTRUCTORES - MÉTODOS;
    // CONSTRUCTOR POR DEFECTO;

    // CONSTRUCTOR PARAMETRIZADO;
    public PersonaController(@Autowired PersonaService personaService) {
        this.personaService = personaService;
    }

    // FINDALL();
    @GetMapping
    public ResponseEntity<List<PersonaResponseDTO>> findAllController() {
        List<Persona> personaList = this.personaService.findAllService(); // ENTITY;
        List<PersonaResponseDTO> dtos = new ArrayList<>(); // DTO;

        for(Persona persona : personaList){
            PersonaResponseDTO dto = PersonaMapper.toDTO(persona); // ENTITY -> DTO;
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    // FINDBY(LONG ID);
    @GetMapping("/{id}")
    public ResponseEntity<?> findByController(@PathVariable Long id) {
        try {
            Persona persona = this.personaService.findByService(id);
            PersonaResponseDTO dto = PersonaMapper.toDTO(persona);
            return ResponseEntity.ok(dto); // 200;
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404;
        }
    }

    // FINDBY(STRING DNI);
    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> findByController(@PathVariable String dni){
        try{
            Persona personaController = this.personaService.findByService(dni);
            return ResponseEntity.ok(personaController); // 200;
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());  // 400;
        } catch (PersonaNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404;
        }
    }

    // SAVE(PERSONA PERSONA);
    @PostMapping
    public ResponseEntity<?> saveController(@RequestBody PersonaRequestDTO personaRequestDTO) {
        try{
            // DTO -> ENTITY;
            Persona persona = PersonaMapper.toEntity(personaRequestDTO);

            // GUARDAR PERSONA;
            Persona personaGuardada = this.personaService.saveService(persona);

            // ENTITY -> DTO;
            PersonaResponseDTO response = PersonaMapper.toDTO(personaGuardada);

            return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 CREATED;
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        }
    }

    // DELETEBY(LONG ID);
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBy(@PathVariable Long id) {
        try{
            this.personaService.deleteByService(id);
            return ResponseEntity.noContent().build(); // 204;
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build(); // 400;
        } catch (PersonaNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404;
        }
    }

    // MODIFYBY(LONG ID, PERSONA PERSONA);
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyByController(@PathVariable Long id, @RequestBody Persona persona){
        try{
            // DTO -> ENTITY;

            // MODIFICAR;
            Persona PersonaModifyController = this.personaService.modifyByService(id,persona);

            // ENTITY -> DTO;

            return ResponseEntity.ok(PersonaModifyController); // 200;
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage()); // 400;
        } catch (PersonaNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404;
        }

    }


}
