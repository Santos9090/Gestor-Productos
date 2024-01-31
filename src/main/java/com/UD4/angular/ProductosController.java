package com.UD4.angular;

import com.UD4.persistence.entitys.ProductosEntity;
import com.UD4.persistence.repositorys.ProductosJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    private ProductosJPA Repositorio;

    // Endpoint para obtener todos los productos.
    @GetMapping
    public ResponseEntity<List<ProductosEntity>> obtenerTodosLosProductos() {
        // Obtener la lista completa de productos desde el repositorio.
        List<ProductosEntity> productos = Repositorio.getFullList();
        // Responder con los productos o con NOT_FOUND si la lista está vacía.
        if (productos != null) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para filtrar productos por nombre.
    @GetMapping("/filtrarPorNombre/{clave}")
    public ResponseEntity<List<ProductosEntity>> filtrarPorNombre(@PathVariable String clave) {
        // Obtener la lista de productos filtrados por el nombre proporcionado.
        List<ProductosEntity> productos = Repositorio.filterByName(clave);
        // Responder con los productos filtrados o con NOT_FOUND.
        if (productos != null) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obtener un producto por su ID.
    @GetMapping("/{id}")
    public ResponseEntity<ProductosEntity> obtenerProductoPorId(@PathVariable int id) {
        // Obtener el producto por su ID desde el repositorio.
        ProductosEntity producto = Repositorio.getProductoByID(id);
        // Responder con el producto o con NOT_FOUND.
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo producto.
    @PostMapping
    public ResponseEntity<Void> crearProducto(@RequestBody ProductosEntity producto) {
        // Imprimir mensaje en la consola al intentar crear un producto.
        System.out.println("Producto creándose");
        // Intentar guardar el producto y responder con CREATED si tiene éxito o INTERNAL_SERVER_ERROR si falla.
        boolean creadoExitosamente = Repositorio.saveProduct(producto);
        if (creadoExitosamente) {
            System.out.println("Producto creado");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para modificar un producto por ID y columna.
    @PostMapping("/modificar/{id}/{columna}/{valor}")
    public ResponseEntity<Void> modificar(@PathVariable int id, @PathVariable String columna, @PathVariable String valor) {
        // Intentar modificar el producto y responder con OK si tiene éxito o BAD_REQUEST si falla.
        if (Repositorio.modify(id, columna, valor)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para eliminar un producto por ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        try {
            // Intentar eliminar el producto y responder con OK si tiene éxito o NOT_FOUND si no se encuentra.
            boolean eliminado = Repositorio.deleteByID(id);
            if (eliminado) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Imprimir excepciones en la consola en caso de error.
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
