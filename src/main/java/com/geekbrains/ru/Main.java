package com.geekbrains.ru;

import com.geekbrains.ru.configuration.AppConf;
import com.geekbrains.ru.controller.CartController;
import com.geekbrains.ru.controller.ProductController;
import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.service.ProductService;
import com.geekbrains.ru.service.impl.CartServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class)) {

            // Не стал писать логику консольного варианта приложения, прост прошелся по операциям.

            ProductController productController = context.getBean("productController", ProductController.class);
            ProductService productService = context.getBean("productServiceImpl", ProductService.class);
            CartController cartController = context.getBean("cartController", CartController.class);
            CartServiceImpl cartService = context.getBean("cart", CartServiceImpl.class);

            productController.doPost();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите ID нужного продукта:");
            long id = Long.parseLong(reader.readLine());
            System.out.println("-----------------------------------------");
            System.out.println("Найдены текущие товары:");
            Optional<Product> productById = productService.findById(id);
            long productId = id;
            productById.ifPresent(product -> System.out.println("ID:" + productId + " [" + product.getName() + "]  Цена: " + product.getPrice() + "rub"));

            System.out.println("Попробуем добавить продукт в корзину? (да/нет)");
            String answer = reader.readLine();
            if (!answer.isBlank() && answer.contains("да")) {
                addProductInCart(cartController, cartService, productId);
            }
            System.out.println("Продукты в корзине:");
            showProductInCart(cartService, productId);

            System.out.println("Попробуем удалить продукт из корзины? (да/нет)");
            answer = reader.readLine();
            if (!answer.isBlank() && answer.contains("да")) {
                System.out.println("Укажите ID продукта который хотите удалить");
                id = Long.parseLong(reader.readLine());
                cartService.removeProduct(id);
            }
            System.out.println("Продукты в корзине:");
            showProductInCart(cartService, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showProductInCart(CartServiceImpl cartService, long id) {
        List<Product> productsInCart = cartService.productsInCart();
        if (!productsInCart.isEmpty()) {
            for (Product product : productsInCart) {
                System.out.println("ID:" + id + " [" + product.getName() + "]  Цена: " + product.getPrice() + "rub");
            }
        } else System.out.println("Корзина пуста!");
    }

    private static void addProductInCart(CartController cartController, CartServiceImpl cartService, long id) {
        cartController.doPost(id);
        cartService.addProduct(id);
    }
}
