package com.rtornello.inditex.application.interfaces;


import com.rtornello.inditex.domain.model.Price;
import java.time.LocalDateTime;


public interface PriceService {


    Price getPrice(String dateTime, Integer productId, Integer brandId);

}
