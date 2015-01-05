package org.ogin.controller;

import org.ogin.model.Product;
import org.ogin.model.ProductType;
import org.ogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jabrik on 13/11/2014.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    @Qualifier("productValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        Product product = new Product();
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("product_types", productService.getAllProductTypes());
        return "product";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult , ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "product";
        }
        else {
            productService.add(product);
            return "productList";
        }
    }

    @RequestMapping(value = "/listJson", method = RequestMethod.GET)
    public @ResponseBody List<ProductType> list() {
        List<ProductType> products = productService.getProductTypes();
        return products;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String detail() {
        return "productList";
    }
}
