package com.biblioteca.demobiblioteca.dto;

import java.time.LocalDate;

public class DisponibilidadDTO {
    private boolean disponible;
    private LocalDate fechaPrestamo;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
