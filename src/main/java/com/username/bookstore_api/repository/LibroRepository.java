package com.username.bookstore_api.repository;

import com.username.bookstore_api.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

   // JPA genera las consultas crud automatic
}
