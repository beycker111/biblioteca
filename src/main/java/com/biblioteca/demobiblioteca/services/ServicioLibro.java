package com.biblioteca.demobiblioteca.services;

import com.biblioteca.demobiblioteca.collections.Libro;
import com.biblioteca.demobiblioteca.dto.LibroDTO;
import com.biblioteca.demobiblioteca.mappers.LibroMapper;
import com.biblioteca.demobiblioteca.repositories.RepositorioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioLibro {

    @Autowired
    private RepositorioLibro repositorioLibro;
    private LibroMapper mapper = new LibroMapper();

    public List<LibroDTO> obtenerTodos(){
        List<Libro> libros = (List<Libro>) repositorioLibro.findAll();
        return mapper.fromCollectionList(libros);
    }

    public LibroDTO obtenerPorId(String id){
        Libro libro = repositorioLibro.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return mapper.fromCollection(libro);
    }

    public LibroDTO crear(LibroDTO libroDTO){
        Libro libro = mapper.fromDTO(libroDTO);
        return mapper.fromCollection(repositorioLibro.save(libro));
    }

    public LibroDTO modificar(LibroDTO libroDTO){
        Libro libro = mapper.fromDTO(libroDTO);
        repositorioLibro.findById(libro.getId()).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return mapper.fromCollection(repositorioLibro.save(libro));
    }

    public void borrar(String id){
        repositorioLibro.deleteById(id);
    }



}
