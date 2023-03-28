package com.rtornello.inditex.application.port.input;


import com.rtornello.inditex.application.interfaces.PriceService;
import com.rtornello.inditex.application.port.output.PriceRepository;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.adapters.output.data.PriceData;
import com.rtornello.inditex.infraestructure.adapters.output.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public Price getPrice(String dateTime, Integer productId, Integer brandId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM);
        LocalDateTime dateTimeFormatter = LocalDateTime.parse(dateTime, formatter);
        List<PriceData> priceDataList = priceRepository.findOneByStartDateLessThanEqualAndEndDateGreaterThanEqual(dateTimeFormatter, dateTimeFormatter);

        PriceData result = priceDataList.stream()
            .max(Comparator.comparing(PriceData::getPriority))
            .orElseThrow(NoSuchElementException::new);
// TODO ADD EXCEPTION
//        if (result == null) {
//            throw new PriceNotFoundException("No Price found with these parameters");
//        }

        return  priceMapper.priceDataToPrice(result);
    }


}
