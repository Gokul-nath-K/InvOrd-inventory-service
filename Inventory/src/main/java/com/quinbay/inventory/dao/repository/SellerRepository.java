package com.quinbay.inventory.dao.repository;

import com.quinbay.inventory.dao.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
