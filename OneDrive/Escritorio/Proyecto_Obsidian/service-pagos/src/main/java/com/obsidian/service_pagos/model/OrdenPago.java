package com.obsidian.service_pagos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orden_pago")
public class OrdenPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario id es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El producto id es obligatorio")
    private Long productoId;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double monto;

    private String estado; // PENDIENTE, PAGADO, CANCELADO

    private LocalDateTime fecha;

    private String metodoPago;
}