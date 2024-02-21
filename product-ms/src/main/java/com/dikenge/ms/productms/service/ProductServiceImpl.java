package com.dikenge.ms.productms.service;

import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.models.Products;
import com.dikenge.ms.productms.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        request.setAvailable(true);
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

    @Override
    public boolean inactive(UUID id) {
      Optional<Products> product =  repository.findById(id);
        if(product.isPresent()){
            product.get().setAvailable(false);
            repository.save(product.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<ProductDTO> update(UUID id, ProductDTO request) {
        Optional<Products> product = repository.findById(id);

        if(product.isPresent())
        {
            product.get().setDescription(request.getDescription());
            product.get().setPrice(request.getPrice());
            repository.save(product.get());
            return Optional.of(mapper.map(product.get(), ProductDTO.class));
        }

        return Optional.empty();
    }
}
/*        for (Products product : products)
        {
            ProductDTO resp = mapper.map(product, ProductDTO.class);
            res.add(resp);
        }

 */ // other way to do it...