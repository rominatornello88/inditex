package com.rtornello.inditex.application.port.input;


import com.rtornello.inditex.application.interfaces.PriceService;
import com.rtornello.inditex.application.port.output.PriceRepository;
import com.rtornello.inditex.infraestructure.rest.dto.PriceDto;
import com.rtornello.inditex.infraestructure.rest.mapper.PriceMapper;
import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class PriceServiceImpl implements PriceService {


    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public PriceDto getPrice(UUID id) {
        return priceMapper.toDto(priceRepository.findById(id));
    }

    @Override
    public PriceDto savePrice(PriceDto priceDto) {
        var priceDtoSaved = priceRepository.save(priceMapper.toDomain(priceDto));
        return priceMapper.toDto(priceDtoSaved);
    }


}
