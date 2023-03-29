package com.rtornello.inditex.application.port;


import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.domain.exceptions.PriceNotFoundException;


public interface PriceService {


    Price getPriceByParameters(String dateTime, Integer productId, Integer brandId)
        throws PriceNotFoundException;

}
