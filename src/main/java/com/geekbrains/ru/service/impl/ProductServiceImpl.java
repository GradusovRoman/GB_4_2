package com.geekbrains.ru.service.impl;

import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.repository.ProductRepository;
import com.geekbrains.ru.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {

        return productRepository.findById(id);
    }
}
