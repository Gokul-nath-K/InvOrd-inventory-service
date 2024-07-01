package com.quinbay.inventory.dao.repository;

import com.quinbay.inventory.dao.entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long> {

    List<ProductHistory> findByProductIdOrderByModifiedOnDesc(Long productId);
}