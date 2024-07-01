package com.quinbay.inventory.dao.repository;

import com.quinbay.inventory.dao.entity.Product;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByCode(String code);
}