package com.dikenge.ms.productms.serviceTests;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.dikenge.ms.productms.dto.ProductDTO;
import com.dikenge.ms.productms.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:clear-database.sql"})
@SpringBootTest
public class ServiceTest {

    @Autowired
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

    @Test
    public void shouldGetAllProducts(){
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> responses = service.create(request);
        List<ProductDTO> response = service.getAll();

        assertNotNull(responses);
        assertEquals(responses.get().getName(), response.get(0).getName());
        assertEquals(responses.get().getId(), response.get(0).getId());

        System.out.println("Data from service: " + response.size());

    }

    @Test
    public void shouldGetById(){
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> response= service.create(request);

        UUID id =  response.get().getId();

        Optional<ProductDTO> responseByID = service.getById(id);


        assertNotNull(responseByID);
        assertEquals(request.getName(),
                responseByID.get().getName());
    }

    @Test
    public void shouldUpdate(){
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> response = service.create(request);
        UUID id  = response.get().getId();

        request.setDescription("Asus PC, dos fodidos mauuuuu rijo dos duros eh duro");

        Optional<ProductDTO> updatedProductDTO = service.update(id, request);
        assertNotNull(updatedProductDTO);
        assertEquals(updatedProductDTO.get().getDescription(), request.getDescription());
    }

    @Test
    public void shouldInactiveProduct(){
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> response = service.create(request);
        UUID id = response.get().getId();

        boolean inactive = service.inactive(id);
        assertTrue(inactive);
    }
}
