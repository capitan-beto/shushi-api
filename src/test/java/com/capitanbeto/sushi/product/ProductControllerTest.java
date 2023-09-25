package com.capitanbeto.sushi.product;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest({ProductController.class})
@ExtendWith({SpringExtension.class})
class ProductControllerTest {

    @Autowired
    MockMvc mvc;

}
