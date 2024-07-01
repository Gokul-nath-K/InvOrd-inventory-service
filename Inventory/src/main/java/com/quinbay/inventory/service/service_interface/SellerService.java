package com.quinbay.inventory.service.service_interface;

import com.quinbay.inventory.dto.SellerRequestDTO;
import com.quinbay.inventory.dao.entity.Seller;

import java.util.List;

public interface SellerService {

    List<Seller> getAllSellers();

    public Seller getById(Long id);

    Seller createSeller(SellerRequestDTO seller);

    Seller updateSeller(Long id, Seller seller);

    void deleteSeller(Long id);
}
