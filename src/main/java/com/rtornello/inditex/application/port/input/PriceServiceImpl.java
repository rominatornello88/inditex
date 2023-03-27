package com.rtornello.inditex.application.port.input;


import com.rtornello.inditex.application.interfaces.PriceService;
import com.rtornello.inditex.application.port.output.PriceRepository;
import com.rtornello.inditex.domain.model.Price;
import com.rtornello.inditex.infraestructure.adapters.output.mapper.PriceMapper;
import org.springframework.stereotype.Service;


@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public Price getPrice(Integer id) {
        return priceMapper.priceDataToPrice(priceRepository.findById(id));
    }


}
