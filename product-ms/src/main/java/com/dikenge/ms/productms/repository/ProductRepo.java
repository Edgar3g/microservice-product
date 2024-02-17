package com.dikenge.ms.productms.repository;

import com.dikenge.ms.productms.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository <Products, UUID> {

}
