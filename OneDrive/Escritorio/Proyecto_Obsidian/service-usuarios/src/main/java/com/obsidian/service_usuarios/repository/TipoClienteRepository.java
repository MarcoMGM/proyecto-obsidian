package com.obsidian.service_usuarios.repository;

import com.obsidian.service_usuarios.model.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {
}