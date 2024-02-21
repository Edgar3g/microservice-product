package com.dikenge.ms.productms.serviceTests;

import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.service.ProductService;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceTest {

    private ProductService service;
    private ProductDTO request;

    public void setUp(){
        request = new ProductDTO();
        request.setName("Arroz");
        request.setDescription("Arroz Com feijão, é um otimo acompanhate e tal num sei das quantas etc, etc, ponto.");
        request.setPrice(10020424.398F);

    }

    @Test
    public void shouldCreateProduct(){
        Optional<ProductDTO> response = service.create(request);

        assertNotNull(response.get());
        assertEquals(request.getName(), response.get().getName());
        assertEquals(request.getDescription(), response.get().getDescription());
        assertEquals(request.getPrice(), response.get().getPrice());
        assertTrue(response.get().isAvailable());
    }
}
