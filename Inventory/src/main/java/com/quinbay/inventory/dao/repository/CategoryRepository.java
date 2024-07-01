package com.quinbay.inventory.dao.repository;

import com.quinbay.inventory.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCode(String code);
}
