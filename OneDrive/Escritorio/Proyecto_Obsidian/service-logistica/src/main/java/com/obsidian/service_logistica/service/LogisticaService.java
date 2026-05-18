package com.obsidian.service_logistica.service;

import com.obsidian.service_logistica.model.Envio;
import com.obsidian.service_logistica.repository.EnvioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LogisticaService {

    private static final Logger log = LoggerFactory.getLogger(LogisticaService.class);

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> listarEnvios() {
        log.info("Listando todos los envios");
        return envioRepository.findAll();
    }

    public Envio crearEnvio(Envio envio) {
        log.info("Creando envio para orden id: {}", envio.getOrdenPagoId());
        envio.setEstado("PREPARANDO");
        envio.setFechaEnvio(LocalDateTime.now());
        envio.setTrackingCode(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        return envioRepository.save(envio);
    }

    public Envio obtenerEnvio(Long id) {
        log.info("Buscando envio con id: {}", id);
        return envioRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Envio no encontrado con id: {}", id);
                return new RuntimeException("Envio no encontrado con id: " + id);
            });
    }

    public Envio actualizarEstado(Long id, String estado) {
        log.info("Actualizando estado de envio id: {} a {}", id, estado);
        Envio envio = obtenerEnvio(id);
        envio.setEstado(estado);
        return envioRepository.save(envio);
    }
}