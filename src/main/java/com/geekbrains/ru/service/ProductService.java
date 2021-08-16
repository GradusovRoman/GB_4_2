package com.geekbrains.ru.service;

import com.geekbrains.ru.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById (long id);
}
