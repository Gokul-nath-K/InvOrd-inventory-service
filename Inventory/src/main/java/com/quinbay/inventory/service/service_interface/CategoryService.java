package com.quinbay.inventory.service.service_interface;

import com.quinbay.inventory.dto.CategoryRequestDTO;
import com.quinbay.inventory.dto.ProductResponseDTO;
import com.quinbay.inventory.dao.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAll();

    public Category  getByCode(String code);

    public Category addNewCategory(CategoryRequestDTO category);

    public List<ProductResponseDTO> getProducts(String categoryCode);
}
