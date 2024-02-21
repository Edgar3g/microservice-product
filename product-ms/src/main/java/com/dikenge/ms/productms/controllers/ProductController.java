package com.dikenge.ms.productms.controllers;

import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable("id") UUID id)
    {
        Optional<ProductDTO> response = service.getById(id);
        return response.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID id, @RequestBody @Valid  ProductDTO request)
    {
        Optional<ProductDTO> response = service.update(id, request);

        if(response.isPresent())
        {
            return ResponseEntity.ok(response.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> inactive(@PathVariable("id") UUID id)
    {
        boolean inactive = service.inactive(id);
        return inactive
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
