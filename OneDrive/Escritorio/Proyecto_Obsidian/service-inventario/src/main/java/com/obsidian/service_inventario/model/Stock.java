package com.obsidian.service_inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El producto id es obligatorio")
    private Long productoId;

    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;

    private String codigoAlmacenamiento;
}