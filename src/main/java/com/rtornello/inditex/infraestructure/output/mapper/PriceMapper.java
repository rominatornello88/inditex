package com.rtornello.inditex.infraestructure.output.mapper;

import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.output.data.PriceData;
import org.springframework.stereotype.Component;


@Component
public class PriceMapper {

    public static Price priceDataToPrice(PriceData priceData) {
        return Price.builder()
            .id(priceData.getId())
            .productId(priceData.getProduct().getId())
            .brandId(priceData.getBrand().getId())
            .priceList(priceData.getPriceList())
            .startDate(priceData.getStartDate())
            .endDate(priceData.getEndDate())
            .price(priceData.getPrice())
            .priority(priceData.getPriority())
            .priceList(priceData.getPriceList())
            .currency(priceData.getCurrency())
            .build();
    }

}
