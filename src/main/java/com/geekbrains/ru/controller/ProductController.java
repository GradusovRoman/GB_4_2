package com.geekbrains.ru.controller;

import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.service.ProductService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

        System.out.println("New Product Controller");
        System.out.println("Список товаров:");
    }

    public void doPost() {
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + " Title: " + product.getName() + " Price: " + product.getPrice());
        }
    }
}
