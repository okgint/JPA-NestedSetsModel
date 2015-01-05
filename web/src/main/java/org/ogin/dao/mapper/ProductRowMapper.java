package org.ogin.dao.mapper;

import org.ogin.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jabrik on 13/11/2014.
 */
public class ProductRowMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductResultSetExtractor().extractData(rs);
    }
}
