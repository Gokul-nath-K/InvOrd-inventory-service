package com.quinbay.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductHistoryDTO {

    private String newValue;
    private String oldValue;
    private String column;
    private String productCode;
}
