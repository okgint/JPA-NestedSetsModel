package org.ogin.dao.mapper;

import org.ogin.model.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jabrik on 13/11/2014.
 */
public class ProductResultSetExtractor implements ResultSetExtractor<Product> {
    @Override
    public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
        Product product = new Product();
        product.setId(rs.getBigDecimal("id"));
        product.setProductTypesId(rs.getBigDecimal("product_types_id"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setName(rs.getString("name"));
        product.setActive(rs.getString("active"));
        return product;
    }
}
