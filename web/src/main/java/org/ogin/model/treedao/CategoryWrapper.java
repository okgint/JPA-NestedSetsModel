package org.ogin.model.treedao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jabrik on 22/11/2014.
 */
public class CategoryWrapper implements Serializable {
    Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
