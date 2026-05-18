package com.obsidian.service_pagos.service;

import com.obsidian.service_pagos.model.OrdenPago;
import com.obsidian.service_pagos.repository.OrdenPagoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagoService {

    private static final Logger log = LoggerFactory.getLogger(PagoService.class);

    @Autowired
    private OrdenPagoRepository ordenPagoRepository;

    public List<OrdenPago> listarOrdenes() {
        log.info("Listando todas las ordenes de pago");
        return ordenPagoRepository.findAll();
    }

    public OrdenPago crearOrden(OrdenPago orden) {
        log.info("Creando orden de pago para usuario id: {}", orden.getUsuarioId());
        orden.setEstado("PENDIENTE");
        orden.setFecha(LocalDateTime.now());
        return ordenPagoRepository.save(orden);
    }

    public OrdenPago obtenerOrden(Long id) {
        log.info("Buscando orden con id: {}", id);
        return ordenPagoRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Orden no encontrada con id: {}", id);
                return new RuntimeException("Orden no encontrada con id: " + id);
            });
    }

    public OrdenPago procesarPago(Long id) {
        log.info("Procesando pago de orden id: {}", id);
        OrdenPago orden = obtenerOrden(id);
        if (!orden.getEstado().equals("PENDIENTE")) {
            throw new RuntimeException("La orden no está en estado PENDIENTE");
        }
        orden.setEstado("PAGADO");
        return ordenPagoRepository.save(orden);
    }

    public OrdenPago cancelarOrden(Long id) {
        log.info("Cancelando orden id: {}", id);
        OrdenPago orden = obtenerOrden(id);
        orden.setEstado("CANCELADO");
        return ordenPagoRepository.save(orden);
    }
}