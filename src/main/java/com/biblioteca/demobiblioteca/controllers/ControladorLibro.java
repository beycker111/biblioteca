package com.biblioteca.demobiblioteca.controllers;

import com.biblioteca.demobiblioteca.dto.LibroDTO;
import com.biblioteca.demobiblioteca.services.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/libros")
@RestController
public class ControladorLibro {

    @Autowired
    private ServicioLibro servicioLibro;

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> findById(@PathVariable("id") String id){
        return new ResponseEntity(servicioLibro.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<LibroDTO>> findAll(){
        return new ResponseEntity(servicioLibro.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<LibroDTO> create(@RequestBody LibroDTO libroDTO){
        return new ResponseEntity(servicioLibro.crear(libroDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<LibroDTO> update(@RequestBody LibroDTO libroDTO){
        if(libroDTO.getId() != null){
            return new ResponseEntity(servicioLibro.modificar(libroDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            servicioLibro.borrar(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
