package org.ogin.model.treedao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jabrik on 22/11/2014.
 */
public class CategoriesWrapper implements Serializable {
    private List<CategoriesWrapper> categories = new ArrayList<>();

    public List<CategoriesWrapper> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesWrapper> categories) {
        this.categories = categories;
    }

    public void add(CategoriesWrapper wrapper) {
        this.categories.add(wrapper);
    }
}
