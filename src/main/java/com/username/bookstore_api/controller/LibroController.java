package com.username.bookstore_api.controller;


import com.username.bookstore_api.model.Libro;
import com.username.bookstore_api.repository.LibroRepository;
import jakarta.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/libros")
public class LibroController {


    private LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crearLibro(@Valid @RequestBody Libro libro, BindingResult result) throws MethodArgumentNotValidException {
        if (result.hasErrors()) {
            throw new MethodArgumentNotValidException(null, result);
        }
        return ResponseEntity.ok(libroRepository.save(libro));
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Long id) {
        try {
            libroRepository.deleteById(id);
            return ResponseEntity.ok("Libro eliminado exitosamente");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el libro con ID: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLibro(
            @PathVariable Long id,
            @Valid @RequestBody Libro libroActualizado) {  // Sin BindingResult

        return libroRepository.findById(id)
                .map(libro -> {
                    // Solo actualiza si los datos son válidos
                    libro.setTitulo(libroActualizado.getTitulo());
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setPrecio(libroActualizado.getPrecio());
                    return ResponseEntity.ok(libroRepository.save(libro));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
