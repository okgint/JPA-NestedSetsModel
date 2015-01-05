package org.ogin.dao.mapper;

import org.ogin.model.ProductType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jabrik on 13/11/2014.
 */
public class ProductTypeRowMapper implements RowMapper<ProductType> {

    @Override
    public ProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductTypeResultSetExtractor().extractData(rs);
    }
}
