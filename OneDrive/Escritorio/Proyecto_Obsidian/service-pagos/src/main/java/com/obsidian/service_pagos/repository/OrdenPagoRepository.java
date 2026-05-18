package com.obsidian.service_pagos.repository;

import com.obsidian.service_pagos.model.OrdenPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenPagoRepository extends JpaRepository<OrdenPago, Long> {
}