package com.UD4.persistence.repositorys;

import com.UD4.persistence.entitys.ProductosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductosJPA implements ProductosRepository {

    @PersistenceContext
    EntityManager manager;

    public List<ProductosEntity> getFullList() {
        // Consulta para obtener la lista completa de productos.
        TypedQuery<ProductosEntity> consulta = manager.createQuery("select p from ProductosEntity p", ProductosEntity.class);
        return consulta.getResultList();
    }

    @Override
    public List<ProductosEntity> filterByName(String clave) {
        // Consulta para filtrar productos por nombre.
        TypedQuery<ProductosEntity> consulta = manager.createQuery("SELECT p FROM ProductosEntity p WHERE LOWER(p.nombre) LIKE LOWER('%' || :clave || '%')", ProductosEntity.class).setParameter("clave", clave);
        return consulta.getResultList();
    }

    public ProductosEntity getProductoByName(String name) {
        // Consulta para obtener un producto por nombre.
        TypedQuery<ProductosEntity> consulta = manager.createQuery("select p from ProductosEntity p where p.nombre = :nombre", ProductosEntity.class);
        consulta.setParameter("nombre", name);
        List<ProductosEntity> resultados = consulta.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public ProductosEntity getProductoByID(int id) {
        // Obtener un producto por su ID.
        return manager.find(ProductosEntity.class, id);
    }

    @Transactional
    public boolean saveProduct(ProductosEntity producto) {
        // Persistir un nuevo producto en la base de datos.
        try {
            manager.persist(producto);
            return true; // Indica que la persistencia fue exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Indica que la persistencia falló
        }
    }

    @Transactional
    public boolean deleteByID(int id) {
        // Eliminar un producto por su ID.
        try {
            ProductosEntity producto = manager.find(ProductosEntity.class, id);
            if (producto != null) {
                manager.remove(producto);
                return true; // Indica que la eliminación fue exitosa
            } else {
                return false; // Indica que el producto no fue encontrado
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            return false; // Indica que la eliminación falló
        }
    }

    @Override
    @Transactional
    public boolean modify(int id, String columna, String valor) {
        // Modificar un atributo específico de un producto por su ID.
        ProductosEntity producto = getProductoByID(id);
        ProductosEntity productoMod = producto;
        if (productoMod != null) {
            try {
                // Modificar la columna especificada con el nuevo valor.
                if ("nombre".equalsIgnoreCase(columna)) {
                    productoMod.setNombre(valor);
                } else if ("precio".equalsIgnoreCase(columna)) {
                    productoMod.setPrecio(Integer.parseInt(valor));
                } else if ("cantidad".equalsIgnoreCase(columna)) {
                    productoMod.setCantidad(Integer.parseInt(valor));
                } else if ("categoria".equalsIgnoreCase(columna)) {
                    productoMod.setCategoria(valor);
                } else {
                    return false;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
            // Persistir el producto modificado.
            manager.persist(productoMod);
            return true;
        } else {
            return false;
        }
    }
}
