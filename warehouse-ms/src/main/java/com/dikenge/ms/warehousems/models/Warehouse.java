package com.dikenge.ms.warehousems.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="tb_warehouse")
public class Werehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private UUID id;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column()
    private int quantity;


}
