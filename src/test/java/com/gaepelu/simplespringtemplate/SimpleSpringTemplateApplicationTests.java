package com.gaepelu.simplespringtemplate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SimpleSpringTemplateApplicationTests {


    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        log.info("context loads");
    }

    @WithMockUser(value = "spring")
    @Test
    void testApi() throws Exception {
        mvc.perform(get("/schools").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
