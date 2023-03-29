package com.rtornello.inditex.application.port;


import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.domain.Exceptions.PriceNotFoundException;


public interface PriceService {


    Price getPrice(String dateTime, Integer productId, Integer brandId)
        throws PriceNotFoundException;

}
