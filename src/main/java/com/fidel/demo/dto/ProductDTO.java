package com.fidel.demo.dto;

import java.time.LocalDate;

public record ProductDTO(Long id, String nombre, Double precio, LocalDate CreadoEl, int puerto) {

}
