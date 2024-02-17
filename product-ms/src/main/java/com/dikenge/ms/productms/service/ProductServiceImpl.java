package com.dikenge.ms.productms.service;

import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.models.Products;
import com.dikenge.ms.productms.repository.ProductRepo;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repository;
    @Override
    public Optional<ProductDTO> create(@org.jetbrains.annotations.NotNull ProductDTO request) {

        ModelMapper mapper = new ModelMapper();
        Products product = mapper.map(request, Products.class);
        repository.saveAndFlush(product);

        ProductDTO resp = mapper.map(product, ProductDTO.class);
        return Optional.of(resp);
    }
}
