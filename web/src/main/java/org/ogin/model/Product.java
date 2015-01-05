package org.ogin.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jabrik on 12/11/2014.
 */
public class Product implements Serializable {
    @NotNull
    private BigDecimal id;
    private BigDecimal productTypesId;

    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String active;

    public Product() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getProductTypesId() {
        return productTypesId;
    }

    public void setProductTypesId(BigDecimal productTypesId) {
        this.productTypesId = productTypesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
