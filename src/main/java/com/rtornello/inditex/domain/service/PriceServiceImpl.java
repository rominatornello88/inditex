package com.rtornello.inditex.domain.service;


import com.rtornello.inditex.application.port.PriceRepository;
import com.rtornello.inditex.application.port.PriceService;
import com.rtornello.inditex.domain.Exceptions.PriceNotFoundException;
import com.rtornello.inditex.domain.constants.ConstantPrice;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.output.data.PriceData;
import com.rtornello.inditex.infraestructure.output.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {


    @Autowired
    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public Price getPrice(String dateTime, Integer productId, Integer brandId)
        throws PriceNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConstantPrice.YYYY_MM_DD_HH_MM);
        LocalDateTime dateTimeFormatter = LocalDateTime.parse(dateTime, formatter);
        List<PriceData> priceDataList = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            productId, brandId, dateTimeFormatter, dateTimeFormatter);

        Optional<PriceData> result = priceDataList.stream()
            .max(Comparator.comparing(PriceData::getPriority));

        if (result.isEmpty()) {
            throw new PriceNotFoundException(ConstantPrice.NO_PRICE_FOUND_WITH_THESE_PARAMETERS);
        }

        return priceMapper.priceDataToPrice(result.get());
    }


}
