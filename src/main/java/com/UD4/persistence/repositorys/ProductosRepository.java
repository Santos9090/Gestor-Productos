package com.UD4.persistence.repositorys;

import com.UD4.persistence.entitys.ProductosEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository {
    public List<ProductosEntity> getFullList();

    public List<ProductosEntity> filterByName(String clave);

    public ProductosEntity getProductoByID(int id);

    public boolean saveProduct(ProductosEntity producto);

    public boolean deleteByID(int id);

    public boolean modify(int id, String columna, String valor);
}

