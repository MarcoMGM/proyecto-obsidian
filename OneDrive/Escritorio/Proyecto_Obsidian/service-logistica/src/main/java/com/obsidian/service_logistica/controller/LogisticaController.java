package com.obsidian.service_logistica.controller;

import com.obsidian.service_logistica.model.Envio;
import com.obsidian.service_logistica.service.LogisticaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logistica")
public class LogisticaController {

    @Autowired
    private LogisticaService logisticaService;

    @GetMapping
    public ResponseEntity<List<Envio>> listar() {
        return ResponseEntity.ok(logisticaService.listarEnvios());
    }

    @PostMapping
    public ResponseEntity<Envio> crear(@Valid @RequestBody Envio envio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(logisticaService.crearEnvio(envio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> ver(@PathVariable Long id) {
        return ResponseEntity.ok(logisticaService.obtenerEnvio(id));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Envio> actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        return ResponseEntity.ok(logisticaService.actualizarEstado(id, estado));
    }
}