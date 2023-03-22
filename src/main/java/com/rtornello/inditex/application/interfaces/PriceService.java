package com.rtornello.inditex.application.interfaces;


import com.rtornello.inditex.infraestructure.rest.dto.PriceDto;
import java.util.UUID;

public interface PriceService {


    PriceDto getPrice(UUID id);
    PriceDto savePrice(PriceDto toDomain);
}
