package com.quinbay.inventory.controller;

import com.quinbay.inventory.dto.CategoryRequestDTO;
import com.quinbay.inventory.dto.ProductResponseDTO;
import com.quinbay.inventory.exceptions.CategoryException;
import com.quinbay.inventory.dao.entity.Category;
import com.quinbay.inventory.service.service_interface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }


    @GetMapping("/getByCode")
    public Category getCategoryById(@RequestParam(value = "code") String code) {
        return Optional.ofNullable(categoryService.getByCode(code))
                .orElseThrow(() -> new CategoryException("Category not found with code: " + code));
    }

    @GetMapping("/{code}/getProducts")
    public List<ProductResponseDTO> getProduct(@PathVariable("code") String categoryCode) {

        return categoryService.getProducts(categoryCode);
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody CategoryRequestDTO category) {
        return categoryService.addNewCategory(category);
    }
}
