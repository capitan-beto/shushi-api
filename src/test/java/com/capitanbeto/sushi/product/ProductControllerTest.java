package com.capitanbeto.sushi.product;

import com.capitanbeto.sushi.config.SecurityConfig;
import com.capitanbeto.sushi.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ProductController.class})
@ExtendWith({SpringExtension.class})
@Import({SecurityConfig.class, TokenService.class})
class ProductControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    ProductService service;

    private Product products;

    @BeforeEach
    public void setup() {
        products = new Product(
                "Full Salmon X45",
                13,
                "combos",
                "45 pieces of Sake, Cream Roll, Salmon Maki, Feel Roll, Tropical, SPF, Geisha, Nigiri, Sashimi",
                "www.imagen.com");
    }

    @Test
    void testProducts() throws Exception {
        when(service.getProducts()).thenReturn(Collections.singletonList(products));
        mvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Full Salmon X45")));
    }

    @Test
    void testGetSingleProduct() throws Exception {
        when(service.getSingleProducts(1L)).thenReturn(new ResponseEntity<>(products, HttpStatus.OK));
        MvcResult result = mvc.perform(get("/api/v1/products/1"))
                .andExpect(status().isOk()).andReturn();
        assertThat("Full Salmon X45", result.getResponse().getContentAsString().contains("Full Salmon X45"));
    }

    @Test
    void testPostProduct() throws Exception {
        when(service.newProduct(products)).thenReturn(new ResponseEntity<>(products, HttpStatus.CONFLICT));
        mvc.perform(post("/api/v1/products")
                .content(new ObjectMapper().writeValueAsString(products))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
