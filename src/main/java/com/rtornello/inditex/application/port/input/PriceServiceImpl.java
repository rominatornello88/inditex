package com.rtornello.inditex.application.port.input;


import com.rtornello.inditex.application.interfaces.PriceService;
import com.rtornello.inditex.application.port.output.PriceRepository;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.adapters.output.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;


@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public Price getPrice(String dateTime, Integer productId, Integer brandId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTimeFormatter = LocalDateTime.parse(dateTime, formatter);
        return  priceMapper.priceDataToPrice(priceRepository.findOneByStartDateLessThanEqualAndEndDateGreaterThanEqual(dateTimeFormatter, dateTimeFormatter));
    }


}
