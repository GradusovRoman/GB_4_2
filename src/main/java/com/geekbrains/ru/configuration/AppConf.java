package com.geekbrains.ru.configuration;

import com.geekbrains.ru.domain.Product;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"com.geekbrains.ru.controller","com.geekbrains.ru.repository","com.geekbrains.ru.service",})
public class AppConf {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Product simpleProduct () {
        return new Product(1,"some product",10.1);
    }
}
