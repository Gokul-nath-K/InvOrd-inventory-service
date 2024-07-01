package com.quinbay.inventory.controller;

import com.quinbay.inventory.dto.ProductRequestDTO;
import com.quinbay.inventory.dto.ProductResponseDTO;
import com.quinbay.inventory.dao.entity.Product;
import com.quinbay.inventory.service.service_interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductResponseDTO> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/getByCode")
    public ProductResponseDTO getByCode(@RequestParam("id") String productId) {
        return productService.getByCode(productId);
    }

    @GetMapping("/getByProductCode")
    public ProductResponseDTO getProductByCode(@RequestParam("id") String productId) {
        return productService.getByCode(productId);
    }

    @PostMapping("/add")
    public Product addNewProduct(@RequestBody ProductRequestDTO product) {
        return productService.addNewProduct(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody ProductRequestDTO updatedProduct) {

        return productService.update(updatedProduct);
    }

    @DeleteMapping("/delete/{code}")
    public String deleteProduct(@PathVariable("code") String code) {
        return productService.deleteProduct(code) ? "Deleted successfully" : "Deletion failed!";
    }
}