package com.carboard.center.api;

import com.carboard.domain.brand.Brand;
import com.carboard.domain.brand.BrandRepository;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BrandApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    BrandRepository brandRepository;

    @Test
    public void createBrand() throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "test");

        mockMvc.perform(
            post("/api/v1/brands")
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"));
    }

    @Test
    public void getBrand() throws Exception {
        Brand brand = new Brand("test");
        brandRepository.save(brand);

        mockMvc.perform(get("/api/v1/brands/{brand_id}", 1))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("존재하지 않는 브랜드 id 값을 넘길 경우 400 BAD_REQUEST 예외를 리턴한다.")
    public void getBrand_id_not_found_error() throws Exception {
        mockMvc.perform(get("/api/v1/brands/{brand_id}", 1))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errorType", notNullValue()))
            .andExpect(jsonPath("$.errorTime", notNullValue()))
            .andExpect(jsonPath("$.msg", notNullValue()));
    }

    @Test
    public void getBrands() throws Exception {
        brandRepository.save(new Brand("test1"));
        brandRepository.save(new Brand("test2"));

        mockMvc.perform(get("/api/v1/brands"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateBrand() throws Exception {
        brandRepository.save(new Brand("test1"));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "test");

        mockMvc.perform(
                put("/api/v1/brands/{brand_id}", 1)
                    .content(jsonObject.toString())
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}