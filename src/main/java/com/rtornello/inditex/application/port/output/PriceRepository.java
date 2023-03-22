package com.rtornello.inditex.application.port.output;

import com.rtornello.inditex.domain.model.Price;
import java.io.Serializable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Serializable> {

    Price findById(UUID uuid);

    Price save(Price price);

}
