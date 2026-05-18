package com.obsidian.service_inventario.controller;

import com.obsidian.service_inventario.model.MovimientoInventario;
import com.obsidian.service_inventario.model.Stock;
import com.obsidian.service_inventario.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/stock")
    public ResponseEntity<List<Stock>> listarStock() {
        return ResponseEntity.ok(inventarioService.listarStock());
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> verStock(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.obtenerStock(id));
    }

    @PostMapping("/stock")
    public ResponseEntity<Stock> crearStock(@Valid @RequestBody Stock stock) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.crearStock(stock));
    }

    @PostMapping("/movimientos")
    public ResponseEntity<MovimientoInventario> registrarMovimiento(@Valid @RequestBody MovimientoInventario movimiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.registrarMovimiento(movimiento));
    }

    @GetMapping("/movimientos")
    public ResponseEntity<List<MovimientoInventario>> listarMovimientos() {
        return ResponseEntity.ok(inventarioService.listarMovimientos());
    }
}