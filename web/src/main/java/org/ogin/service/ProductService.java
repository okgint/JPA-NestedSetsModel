package org.ogin.service;

import org.ogin.model.Product;
import org.ogin.model.ProductType;

import java.util.List;

/**
 * Created by Jabrik on 12/11/2014.
 */
public interface ProductService {
    public List<Product> getAllProducts();

    public void add(Product product);

    public void addProduct(Product product, ProductType type);

    // SELECT *
    public List<ProductType> getAllProductTypes();
    
    // ProductType & Product
    public List<ProductType> getProductTypes();

    public void addType(ProductType productType);
}
