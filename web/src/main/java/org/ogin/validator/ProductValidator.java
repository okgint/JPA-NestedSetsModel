package org.ogin.validator;

import org.ogin.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jabrik on 13/11/2014.
 */
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "firstName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "active", "price.required");

    }
}
