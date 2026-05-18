package com.obsidian.service_usuarios.controller;

import com.obsidian.service_usuarios.model.TipoCliente;
import com.obsidian.service_usuarios.model.Usuario;
import com.obsidian.service_usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> ver(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuario(id));
    }

    @GetMapping("/tipos")
    public ResponseEntity<List<TipoCliente>> listarTipos() {
        return ResponseEntity.ok(usuarioService.listarTipos());
    }

    @PostMapping("/tipos")
    public ResponseEntity<TipoCliente> crearTipo(@Valid @RequestBody TipoCliente tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearTipo(tipo));
    }
}