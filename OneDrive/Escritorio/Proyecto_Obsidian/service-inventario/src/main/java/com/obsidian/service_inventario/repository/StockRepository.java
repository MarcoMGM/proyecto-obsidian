package com.obsidian.service_inventario.repository;

import com.obsidian.service_inventario.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}