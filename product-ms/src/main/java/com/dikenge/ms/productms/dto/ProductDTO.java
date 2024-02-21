package com.dikenge.ms.productms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    @NotBlank
    private String name;

    @Positive
    private BigDecimal price = new BigDecimal("0.0");

    @Size(min = 50)
    private String description;
    private boolean isAvailable;
}

