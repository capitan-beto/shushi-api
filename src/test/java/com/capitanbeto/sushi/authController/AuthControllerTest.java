package com.capitanbeto.sushi.authController;

import com.capitanbeto.sushi.config.SecurityConfig;
import com.capitanbeto.sushi.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class AuthControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void RootWhenAuthenticatedThen401() throws Exception {
        this.mvc.perform(get("/token"))
                .andExpect(status().isUnauthorized());

    }

    @Test
    void rootWhenAuthenticatedThen200() throws Exception {
        this.mvc.perform(post("/token")
                .with(httpBasic("carlitos1998", "abcedt")))
                .andExpect(status().isUnauthorized());

    }

}
