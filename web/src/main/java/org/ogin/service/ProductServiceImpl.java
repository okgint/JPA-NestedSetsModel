package org.ogin.service;

import org.ogin.dao.ProductDao;
import org.ogin.model.Product;
import org.ogin.model.ProductType;

import java.util.List;

/**
 * Created by Jabrik on 12/11/2014.
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public void addProduct(Product product, ProductType type) {
        productDao.addProduct(product, type);
    }

    @Override
    public List<ProductType> getProductTypes() {
        return productDao.getProductTypes();
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        return productDao.getAllProductTypes();
    }

    @Override
    public void addType(ProductType productType) {
        productDao.addType(productType);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
