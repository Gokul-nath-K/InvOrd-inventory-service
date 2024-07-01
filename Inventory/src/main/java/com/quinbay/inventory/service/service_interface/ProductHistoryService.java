package com.quinbay.inventory.service.service_interface;

import com.quinbay.inventory.dto.ProductHistoryDTO;
import com.quinbay.inventory.dao.entity.ProductHistory;
import java.util.List;

public interface ProductHistoryService {

    List<ProductHistory> getProductHistoryByProductId(Long productId);

    ProductHistory addProductHistoryEntry(ProductHistoryDTO productHistoryDTO);
}