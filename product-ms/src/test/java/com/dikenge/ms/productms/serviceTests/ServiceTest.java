package com.dikenge.ms.productms.serviceTests;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceTest {

    private ProductService service;

    @BeforeAll
    public static void setUp(){
        FixtureFactoryLoader.loadTemplates("com.dikenge.ms.productms.fixture");
    }

    @Test
    public void shouldCreateProduct(){
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> response = service.create(request);

        assertNotNull(response.get());
        assertEquals(request.getName(), response.get().getName());
        assertEquals(request.getDescription(), response.get().getDescription());
        assertEquals(request.getPrice(), response.get().getPrice());
        assertTrue(response.get().isAvailable());
    }
}
