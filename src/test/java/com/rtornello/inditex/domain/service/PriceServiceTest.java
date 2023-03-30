package com.rtornello.inditex.domain.service;


import static org.mockito.Mockito.when;

import com.rtornello.inditex.domain.exceptions.PriceNotFoundException;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.output.data.BrandData;
import com.rtornello.inditex.infraestructure.output.data.PriceData;
import com.rtornello.inditex.infraestructure.output.repository.PriceRepository;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest extends BaseTest {


    @InjectMocks
    PriceServiceImpl priceService;

    @Mock
    private PriceRepository priceRepository;
    private Price price;
    private BrandData brandData;


    @Mock
    PriceData priceData;

    @Mock
    PriceData priceData2;

    @Before
    public void setUp() {
        price = priceExample();
        priceData = priceDataExample();
        priceData2 = priceDataExample2();
    }


    @Test
    public void getPriceByParameters() throws PriceNotFoundException {
        when(
            priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                priceExample().getProductId(), priceExample().getBrandId(), dateTimeFormatter,
                dateTimeFormatter)).thenReturn(Arrays.asList(priceData, priceData2));

        var result = priceService.getPriceByParameters(date1, PRICE_ID,
            BRAND_ID);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.getPriority() == 1);

    }
}