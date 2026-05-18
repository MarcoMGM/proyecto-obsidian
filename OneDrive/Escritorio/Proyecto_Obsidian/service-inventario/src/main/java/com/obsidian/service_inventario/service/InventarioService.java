package com.obsidian.service_inventario.service;

import com.obsidian.service_inventario.model.MovimientoInventario;
import com.obsidian.service_inventario.model.Stock;
import com.obsidian.service_inventario.repository.MovimientoInventarioRepository;
import com.obsidian.service_inventario.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventarioService {

    private static final Logger log = LoggerFactory.getLogger(InventarioService.class);

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private MovimientoInventarioRepository movimientoRepository;

    public List<Stock> listarStock() {
        log.info("Listando todo el stock");
        return stockRepository.findAll();
    }

    public Stock obtenerStock(Long id) {
        log.info("Buscando stock con id: {}", id);
        return stockRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Stock no encontrado con id: {}", id);
                return new RuntimeException("Stock no encontrado con id: " + id);
            });
    }

    public Stock crearStock(Stock stock) {
        log.info("Creando stock para producto id: {}", stock.getProductoId());
        return stockRepository.save(stock);
    }

    public MovimientoInventario registrarMovimiento(MovimientoInventario movimiento) {
        log.info("Registrando movimiento tipo: {}", movimiento.getTipo());
        movimiento.setFecha(LocalDateTime.now());
        
        Stock stock = stockRepository.findAll().stream()
            .filter(s -> s.getProductoId().equals(movimiento.getProductoId()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Stock no encontrado para producto id: " + movimiento.getProductoId()));

        if (movimiento.getTipo().equals("ENTRADA")) {
            stock.setCantidad(stock.getCantidad() + movimiento.getCantidad());
        } else if (movimiento.getTipo().equals("SALIDA")) {
            if (stock.getCantidad() < movimiento.getCantidad()) {
                throw new RuntimeException("Stock insuficiente");
            }
            stock.setCantidad(stock.getCantidad() - movimiento.getCantidad());
        }
        
        stockRepository.save(stock);
        return movimientoRepository.save(movimiento);
    }

    public List<MovimientoInventario> listarMovimientos() {
        log.info("Listando movimientos");
        return movimientoRepository.findAll();
    }
}