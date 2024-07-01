package com.quinbay.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    private String code;
    private String name;
    private Double price;
    private Long quantity;
    private String categoryCode;
    private Long sellerId;
}