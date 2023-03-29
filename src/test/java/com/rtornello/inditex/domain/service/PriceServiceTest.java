package com.rtornello.inditex.domain.service;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rtornello.inditex.application.port.PriceRepository;
import com.rtornello.inditex.domain.constants.ConstantPrice;
import com.rtornello.inditex.domain.exceptions.PriceNotFoundException;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.output.data.BrandData;
import com.rtornello.inditex.infraestructure.output.data.PriceData;
import com.rtornello.inditex.infraestructure.output.data.ProductData;
import com.rtornello.inditex.infraestructure.output.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {

    String date1 = "2023-03-29 16:22";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConstantPrice.YYYY_MM_DD_HH_MM);
    LocalDateTime dateTimeFormatter = LocalDateTime.parse(date1, formatter);
    @InjectMocks
    PriceServiceImpl priceService;

    @Mock
    private PriceRepository priceRepository;
    private Price price;
    private BrandData brandData;

    protected Price priceExample() {
        return Price.builder()
            .id(1)
            .currency("EUR")
            .priceList("3")
            .price(15.50F)
            .brandId(1)
            .productId(1)
            .priority("1")
            .endDate(dateTimeFormatter)
            .startDate(dateTimeFormatter)
            .build();
    }

    protected PriceData priceDataExample() {
        ProductData productData = new ProductData(1, "nameProduct");
        BrandData brandData = new BrandData(1, "nameBrand");

        return PriceData.builder()
            .id(1)
            .currency("EUR")
            .priceList("3")
            .price(15.50F)
            .priority("1")
            .product(productData)
            .brand(brandData)
            .endDate(dateTimeFormatter)
            .startDate(dateTimeFormatter)
            .build();
    }

    @Mock
    PriceData priceData;

    @Autowired
    PriceMapper priceMapper;

    @Before
    public void setUp() {
        price = priceExample();
        priceData = priceDataExample();
    }


    @Test
    public void getPriceByParameters() throws PriceNotFoundException {
        when(
            priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceExample().getProductId(), priceExample().getBrandId(), dateTimeFormatter,
                dateTimeFormatter)).thenReturn(Arrays.asList(priceData));

        priceService.getPriceByParameters(date1, priceExample().getProductId(),
            priceExample().getBrandId());
        verify(
            priceRepository).findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            priceExample().getProductId(), priceExample().getBrandId(), dateTimeFormatter,
            dateTimeFormatter);


    }
}