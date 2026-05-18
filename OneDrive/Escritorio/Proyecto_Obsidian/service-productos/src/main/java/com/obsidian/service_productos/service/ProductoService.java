package com.obsidian.service_productos.service;

import com.obsidian.service_productos.model.Categoria;
import com.obsidian.service_productos.model.Producto;
import com.obsidian.service_productos.repository.CategoriaRepository;
import com.obsidian.service_productos.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Producto> listarProductos() {
        log.info("Listando todos los productos");
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto) {
        log.info("Creando producto: {}", producto.getNombre());
        return productoRepository.save(producto);
    }

    public Producto obtenerProducto(Long id) {
        log.info("Buscando producto con id: {}", id);
        return productoRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Producto no encontrado con id: {}", id);
                return new RuntimeException("Producto no encontrado con id: " + id);
            });
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        log.info("Actualizando producto con id: {}", id);
        Producto existente = obtenerProducto(id);
        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        existente.setMaterial(producto.getMaterial());
        existente.setCategoria(producto.getCategoria());
        return productoRepository.save(existente);
    }

    public void eliminarProducto(Long id) {
        log.info("Eliminando producto con id: {}", id);
        obtenerProducto(id);
        productoRepository.deleteById(id);
    }

    public List<Categoria> listarCategorias() {
        log.info("Listando categorias");
        return categoriaRepository.findAll();
    }

    public Categoria crearCategoria(Categoria categoria) {
        log.info("Creando categoria: {}", categoria.getNombre());
        return categoriaRepository.save(categoria);
    }
}