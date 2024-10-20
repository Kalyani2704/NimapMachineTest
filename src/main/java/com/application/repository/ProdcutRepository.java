package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.Product;

public interface ProdcutRepository  extends JpaRepository<Product, Long>{

}
