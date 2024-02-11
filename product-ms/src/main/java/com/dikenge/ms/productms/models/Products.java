package com.dikenge.ms.productms.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name="tb_product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price = new BigDecimal("0.0");
    @Column(nullable = false)
    private String description;
    @Column(nullable = false )
    private boolean isAvailable;

}
