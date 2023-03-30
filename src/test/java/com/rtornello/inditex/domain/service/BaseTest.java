package com.rtornello.inditex.domain.service;

import com.rtornello.inditex.domain.constants.ConstantPrice;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.output.data.BrandData;
import com.rtornello.inditex.infraestructure.output.data.PriceData;
import com.rtornello.inditex.infraestructure.output.data.ProductData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    public static final int PRICE_ID = 1;
    public static final int PRODUCT_ID = 1;
    public static final int BRAND_ID = 11;
    public static final int PRIORITY_ONE = 1;
    public static final int PRIORITY_CERO = 0;
    String date1 = "2023-03-29 16:22";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConstantPrice.YYYY_MM_DD_HH_MM);
    LocalDateTime dateTimeFormatter = LocalDateTime.parse(date1, formatter);

    protected Price priceExample() {
        return Price.builder()
            .id(PRICE_ID)
            .currency("EUR")
            .priceList("3")
            .price(15.50F)
            .brandId(BRAND_ID)
            .productId(PRODUCT_ID)
            .priority(PRIORITY_ONE)
            .endDate(dateTimeFormatter)
            .startDate(dateTimeFormatter)
            .build();
    }

    protected PriceData priceDataExample() {
        ProductData productData = new ProductData(PRODUCT_ID, "nameProduct");
        BrandData brandData = new BrandData(PRODUCT_ID, "nameBrand");

        return PriceData.builder()
            .id(PRODUCT_ID)
            .currency("EUR")
            .priceList("3")
            .price(15.50F)
            .priority(PRIORITY_CERO)
            .product(productData)
            .brand(brandData)
            .endDate(dateTimeFormatter)
            .startDate(dateTimeFormatter)
            .build();
    }

    protected PriceData priceDataExample2() {
        ProductData productData = new ProductData(PRODUCT_ID, "nameProduct2");
        BrandData brandData = new BrandData(BRAND_ID, "nameBrand2");

        return PriceData.builder()
            .id(PRICE_ID)
            .currency("EUR")
            .priceList("3")
            .price(15.50F)
            .priority(PRIORITY_ONE)
            .product(productData)
            .brand(brandData)
            .endDate(dateTimeFormatter)
            .startDate(dateTimeFormatter)
            .build();
    }

}
