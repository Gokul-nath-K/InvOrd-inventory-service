package com.quinbay.inventory.service.implementation;

import com.quinbay.inventory.dto.ProductHistoryDTO;
import com.quinbay.inventory.exceptions.ProductException;
import com.quinbay.inventory.dao.entity.Product;
import com.quinbay.inventory.dao.entity.ProductHistory;
import com.quinbay.inventory.dao.repository.ProductHistoryRepository;
import com.quinbay.inventory.service.service_interface.ProductHistoryService;
import com.quinbay.inventory.service.service_interface.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductHistoryServiceImpl implements ProductHistoryService {

    private final ProductHistoryRepository productHistoryRepository;

    @Lazy
    @Autowired
    private ProductService productService;

    @Override
    public List<ProductHistory> getProductHistoryByProductId(Long productId) {

        return Optional.ofNullable(productHistoryRepository.findByProductIdOrderByModifiedOnDesc(productId))
                .orElseThrow(() -> new ProductException("Product not found!"));
    }

    @Override
    public ProductHistory addProductHistoryEntry(ProductHistoryDTO productHistoryDTO) {

        ProductHistory historyEntry = new ProductHistory();

        Product product = Optional.ofNullable(productService.getByProductCode(productHistoryDTO.getProductCode()))
                        .orElseThrow(() -> new ProductException("Product not found!"));

        historyEntry.setProduct(product);
        historyEntry.setColumn(productHistoryDTO.getColumn());
        historyEntry.setOldValue(productHistoryDTO.getOldValue());
        historyEntry.setNewValue(productHistoryDTO.getNewValue());
        historyEntry.setModifiedOn(LocalDateTime.now());

        return productHistoryRepository.save(historyEntry);
    }
}
