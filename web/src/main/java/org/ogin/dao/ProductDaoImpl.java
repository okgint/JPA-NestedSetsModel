package org.ogin.dao;

import org.ogin.dao.mapper.ProductRowMapper;
import org.ogin.dao.mapper.ProductTypeRowMapper;
import org.ogin.model.Product;
import org.ogin.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jabrik on 12/11/2014.
 */
public class ProductDaoImpl implements ProductDao {
    private static final String CREATE_SQL = "INSERT INTO LOCATIONS( LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, " +
            "STATE_PROVINCE, COUNTRY_ID) " +
            "VALUES (LOCATIONS_SEQ.NEXTVAL, :streetAddress, :postalCode, :city, " +
            ":stateProvince, :countryId)";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        String SQL = "SELECT * FROM PRODUCTS";

        return namedParameterJdbcTemplate.query(SQL, new ProductRowMapper());
    }

    @Override
    public void add(Product product) {
        String SQL = "INSERT INTO PRODUCTS(id, product_types_id, name, price, active) VALUES(PRODUCTS_SEQUENCE.NEXTVAL, :ptid, :nama, :harga, :ac)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("ptid", product.getProductTypesId())
                .addValue("nama", product.getName())
                .addValue("harga", product.getPrice())
                .addValue("ac", product.getActive(), Types.VARCHAR);
        namedParameterJdbcTemplate.update(SQL, params);
    }

    @Override
    public void addProduct(Product product, ProductType type) {
        String SQL = "INSERT INTO PRODUCTS(id, product_types_id, name, price, active) VALUES(PRODUCTS_SEQUENCE.NEXTVAL, :ptid, :nama, :harga, :ac)";
        Number iId = addType(type);
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("ptid", iId)
                .addValue("nama", product.getName())
                .addValue("harga", product.getPrice())
                .addValue("ac", product.getActive(), Types.VARCHAR);
        namedParameterJdbcTemplate.update(SQL, params);
    }

    @Override
    public List<ProductType> getProductTypes() {
        final Map<BigDecimal, ProductType> productTypes = new HashMap<BigDecimal, ProductType>();
        String SQL = "SELECT DISTINCT pt.id pt_id, pt.name pt_name, p.id, P.PRODUCT_TYPES_ID, p.name, p.price, P.ACTIVE from product_types pt inner join products p on pt.id=p.product_types_id";
        String SQL2 = "SELECT pt.id pt_id, pt.name pt_name, p.id, p.name, P.PRODUCT_TYPES_ID, p.price, P.ACTIVE from product_types pt inner join products p on pt.id=p.product_types_id";
        namedParameterJdbcTemplate.query(SQL2, new RowMapper<ProductType>() {
            @Override
            public ProductType mapRow(ResultSet rs, int rowNum) throws SQLException {
                BigDecimal pt_id = rs.getBigDecimal("pt_id");

                ProductType productType = productTypes.get(pt_id);
                if (productType == null) {
                    String name = rs.getString("pt_name");
                    productType = new ProductType();
                    productType.setId(pt_id);
                    productType.setName(name);
                    productTypes.put(pt_id, productType);
                }
                Product product = new Product();
                product.setId(rs.getBigDecimal("id"));
                product.setName(rs.getString("name"));
                product.setActive(rs.getString("active"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setProductTypesId(pt_id);
                productType.getProducts().add(product);

                return productType;
            }
        });
//        List<Department> result = new ArrayList<Department>(departments.values());
        List<ProductType> result = new ArrayList<ProductType>(productTypes.values());


        for (int i = 0; i < result.size(); i++) {
            ProductType tt = result.get(i);
//            System.out.println(tt.getProducts().size());
        }
        return result;
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        String SQL = "SELECT * FROM PRODUCT_TYPES";
        return namedParameterJdbcTemplate.query(SQL, new ProductTypeRowMapper());
    }

    @Override
    public Number addType(ProductType type) {
        String SQL = "INSERT INTO PRODUCT_TYPES(id, name) VALUES(product_types_sequence.NEXTVAL, :nama)";
        String idInserted = "SELECT product_types_sequence.CURRVAL FROM dual";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("nama", type.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL, params, keyHolder, new String[] {"id"});
        return keyHolder.getKey();

    }
}
