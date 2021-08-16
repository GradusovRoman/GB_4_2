package com.geekbrains.ru.controller;

import com.geekbrains.ru.service.CartService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
        System.out.println("New Cart Controller");
    }

    public void doPost(long id) {
        cartService.addProduct(id);
        System.out.println("Статус добавления продукта:" + cartService.addProduct(id));
    }

    public void doRemoveById(long id) {
        cartService.removeProduct(id);
    }
}
