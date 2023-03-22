package com.rtornello.inditex.infraestructure.rest.mapper;

import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.rest.dto.PriceDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PriceMapper {

    //@Mapping(target="priceDto", source="price")
    PriceDto toDto(Price price);

    //@Mapping(target="price", source="priceDto")
    Price toDomain(PriceDto priceDto);

}