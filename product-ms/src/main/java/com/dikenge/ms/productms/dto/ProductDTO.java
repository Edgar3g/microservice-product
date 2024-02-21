package com.dikenge.ms.productms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDTO {
    private UUID id;
    @NotBlank
    private String name;

    @Positive
    private float price;

    @Size(min = 10)
    private String description;
    private boolean isAvailable;
}

