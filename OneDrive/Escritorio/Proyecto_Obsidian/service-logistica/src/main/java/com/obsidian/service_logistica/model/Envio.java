package com.obsidian.service_logistica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El orden pago id es obligatorio")
    private Long ordenPagoId;

    @NotNull(message = "El usuario id es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    private String estado; // PREPARANDO, EN_CAMINO, ENTREGADO

    private LocalDateTime fechaEnvio;

    private String trackingCode;
}