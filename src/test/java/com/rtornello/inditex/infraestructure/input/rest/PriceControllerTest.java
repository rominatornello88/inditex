package com.rtornello.inditex.infraestructure.input.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.rtornello.inditex.domain.model.Price;
import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {
    // TODO FAILED! CHECKED!

    @Autowired
    private MockMvc mvc;


    @Test
    public void getAllEmployeesAPI() throws Exception
    {

        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/")
                .param("date", "2020-12-31 00:00")
                .requestAttr("brandId", 1)
                .requestAttr("productId", 35455)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();

        Assert.assertEquals(200, result.getResponse().getStatus());
    }

    private Price priceExample() {
        return Price.builder()
            .id(1)
            .currency("EUR")
            .priceList("3")
            .price(15.50F)
            .brandId(1)
            .productId(1)
            .endDate(LocalDateTime.parse("2020-06-15T00:00:00"))
            .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
            .build();
    }

}