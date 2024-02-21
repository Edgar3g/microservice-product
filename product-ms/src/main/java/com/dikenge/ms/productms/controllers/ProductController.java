package com.dikenge.ms.productms.controllers;

import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO request)
    {
        Optional <ProductDTO> response = service.create(request);

        return response.map(productDTO -> new ResponseEntity<>(response.get(), HttpStatus.CREATED))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
