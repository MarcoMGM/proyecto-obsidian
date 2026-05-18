package com.obsidian.service_usuarios.service;

import com.obsidian.service_usuarios.model.TipoCliente;
import com.obsidian.service_usuarios.model.Usuario;
import com.obsidian.service_usuarios.repository.TipoClienteRepository;
import com.obsidian.service_usuarios.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    public List<Usuario> listarUsuarios() {
        log.info("Listando todos los usuarios");
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario) {
        log.info("Creando usuario con rut: {}", usuario.getRut());
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuario(Long id) {
        log.info("Buscando usuario con id: {}", id);
        return usuarioRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Usuario no encontrado con id: {}", id);
                return new RuntimeException("Usuario no encontrado con id: " + id);
            });
    }

    public List<TipoCliente> listarTipos() {
        log.info("Listando tipos de cliente");
        return tipoClienteRepository.findAll();
    }

    public TipoCliente crearTipo(TipoCliente tipo) {
        log.info("Creando tipo de cliente: {}", tipo.getNombre());
        return tipoClienteRepository.save(tipo);
    }
}