package com.dikenge.ms.productms.service;

import com.dikenge.ms.productms.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    Optional<ProductDTO> create(ProductDTO request);
}
