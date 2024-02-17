package com.dikenge.ms.productms.service;

import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.models.Products;
import com.dikenge.ms.productms.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Optional<ProductDTO> create(@org.jetbrains.annotations.NotNull ProductDTO request) {

        Products product = mapper.map(request, Products.class);
        repository.saveAndFlush(product);

        ProductDTO resp = mapper.map(product, ProductDTO.class);
        return Optional.of(resp);
    }

    @Override
    public Optional<ProductDTO> getById(UUID id) {
        Optional<Products> product = repository.findById(id);
        return product.map(products -> mapper.map(products, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Products> products = repository.findAll();
        List<ProductDTO> res = new ArrayList<>();



        products.forEach(product -> {
            ProductDTO resp = mapper.map(product, ProductDTO.class);
            res.add(resp);
        });

        return res;
    }
}
/*        for (Products product : products)
        {
            ProductDTO resp = mapper.map(product, ProductDTO.class);
            res.add(resp);
        }

 */ // other way to do it...