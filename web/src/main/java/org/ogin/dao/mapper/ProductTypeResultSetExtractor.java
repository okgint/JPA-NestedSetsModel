package org.ogin.dao.mapper;

import org.ogin.model.ProductType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jabrik on 13/11/2014.
 */
public class ProductTypeResultSetExtractor implements ResultSetExtractor<ProductType> {
    @Override
    public ProductType extractData(ResultSet rs) throws SQLException, DataAccessException {
        ProductType type = new ProductType();
        type.setId(rs.getBigDecimal("id"));
        type.setName(rs.getString("name"));
        return type;
    }
}
