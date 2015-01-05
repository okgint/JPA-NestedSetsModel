package org.ogin.dao;

import org.ogin.model.Product;
import org.ogin.model.ProductType;

import java.util.List;

/**
 * Created by Jabrik on 12/11/2014.
 */
public interface ProductDao {
    public List<Product> getAllProducts();

    public void add(Product product);
    public void addProduct(Product product, ProductType type);

    public List<ProductType> getProductTypes();
    public List<ProductType> getAllProductTypes();

    public Number addType(ProductType type);
}
