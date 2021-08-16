package com.geekbrains.ru.repository;

import com.geekbrains.ru.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(long id);
}
