package com.dikenge.ms.productms.service;

import com.dikenge.ms.productms.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ProductService {

    Optional<ProductDTO> create(ProductDTO request);

    Optional<ProductDTO> getById(UUID id);
    List<ProductDTO> getAll();

    boolean inactive(UUID id);

    Optional<ProductDTO> update(UUID id, ProductDTO request);
}
