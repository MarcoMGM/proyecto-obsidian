package com.obsidian.service_logistica.repository;

import com.obsidian.service_logistica.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}