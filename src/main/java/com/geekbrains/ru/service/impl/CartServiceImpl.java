package com.geekbrains.ru.service.impl;

import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.service.CartService;
import com.geekbrains.ru.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@Service
@Scope(SCOPE_PROTOTYPE)
@Component("cart")
public class CartServiceImpl implements CartService {

    private final ProductService productService;

    private final List<Product> products;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;

        this.products = new ArrayList<>();
    }

    @Override
    public boolean addProduct(long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            products.add(productOptional.get());
            return true;
        }
        return false;
    }

    public List<Product> productsInCart() {

        return products;
    }

    @Override
    public boolean removeProduct(long id) {
        return products.removeIf(product -> product.getId() == id);
    }
}
