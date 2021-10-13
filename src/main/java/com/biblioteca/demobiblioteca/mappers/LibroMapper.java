package com.biblioteca.demobiblioteca.mappers;

import com.biblioteca.demobiblioteca.collections.Libro;
import com.biblioteca.demobiblioteca.dto.LibroDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibroMapper {

    public Libro fromDTO(LibroDTO dto){
        Libro libro = new Libro();
        libro.setId(dto.getId());
        libro.setNombre(dto.getNombre());
        libro.setDisponible(libro.isDisponible());
        libro.setFechaPrestamo(dto.getFechaPrestamo());
        libro.setArea(dto.getArea());
        libro.setTipo(dto.getTipo());
        return libro;
    }

    public LibroDTO fromCollection(Libro collection){
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setId(collection.getId());
        libroDTO.setNombre(collection.getNombre());
        libroDTO.setDisponible(collection.isDisponible());
        libroDTO.setFechaPrestamo(collection.getFechaPrestamo());
        libroDTO.setArea(collection.getArea());
        libroDTO.setTipo(collection.getTipo());
        return libroDTO;
    }

    public List<LibroDTO> fromCollectionList(List<Libro> collection){
        if(collection == null){
            return null;
        }
        List<LibroDTO> list = new ArrayList<>(collection.size());
        Iterator listTracks = collection.iterator();

        while (listTracks.hasNext()){
            Libro libro = (Libro) listTracks.next();
            list.add(fromCollection(libro));
        }

        return list;
    }
}
