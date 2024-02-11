package com.dikenge.ms.warehousems.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class WerehouseDTO {

    private UUID productId;

    private int quantity;
}
