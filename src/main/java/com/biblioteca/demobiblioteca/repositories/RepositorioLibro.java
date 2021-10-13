package com.biblioteca.demobiblioteca.repositories;

import com.biblioteca.demobiblioteca.collections.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface RepositorioLibro extends MongoRepository<Libro, String> {
}
