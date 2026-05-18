package com.obsidian.service_inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movimiento_inventario")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El producto id es obligatorio")
    private Long productoId;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;

    private LocalDateTime fecha;

    private String observacion;
}