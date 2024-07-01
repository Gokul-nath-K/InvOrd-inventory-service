package com.quinbay.inventory.service.service_interface;

import com.quinbay.inventory.dto.ProductRequestDTO;
import com.quinbay.inventory.dto.ProductResponseDTO;
import com.quinbay.inventory.dao.entity.Product;
import java.util.List;

public interface ProductService {

    public List<ProductResponseDTO> getAllProducts();

    public ProductResponseDTO getByCode(String code);

    public Product getByProductCode(String code);

    public Product addNewProduct(ProductRequestDTO product);

    public Product update(ProductRequestDTO product);

    boolean deleteProduct(String code);

}