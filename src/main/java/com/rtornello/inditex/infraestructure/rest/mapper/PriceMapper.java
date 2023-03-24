package com.rtornello.inditex.infraestructure.rest.mapper;

import com.rtornello.inditex.infraestructure.rest.dto.PriceDto;
import com.rtornello.inditex.infraestructure.data.Price;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PriceMapper {

    //@Mapping(target="priceDto", source="price")
    PriceDto toDto(Price price);

    //@Mapping(target="price", source="priceDto")
    Price toDomain(PriceDto priceDto);

}
