package com.username.bookstore_api.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="libros")
@Data //Lobook genera los getters and setters, toString, etc
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre del autor debe tener entre 2 y 100 caracteres")
    private String autor;


    @Positive(message = "El precio debe ser un número positivo")
    private double precio;



}
