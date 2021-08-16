package com.geekbrains.ru.repository.impl;

import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("repository")
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Рубашка ", 1750.1));
        products.add(new Product(2, "Платье", 4200.2));
        products.add(new Product(3, "Джинсы", 3000.3));
        products.add(new Product(4, "Ботинки", 4000.4));
        products.add(new Product(5, "Пальто", 7300.5));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
