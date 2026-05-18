package com.obsidian.service_pagos.controller;

import com.obsidian.service_pagos.model.OrdenPago;
import com.obsidian.service_pagos.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<OrdenPago>> listar() {
        return ResponseEntity.ok(pagoService.listarOrdenes());
    }

    @PostMapping
    public ResponseEntity<OrdenPago> crear(@Valid @RequestBody OrdenPago orden) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.crearOrden(orden));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenPago> ver(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtenerOrden(id));
    }

    @PutMapping("/{id}/procesar")
    public ResponseEntity<OrdenPago> procesar(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.procesarPago(id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<OrdenPago> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.cancelarOrden(id));
    }
}