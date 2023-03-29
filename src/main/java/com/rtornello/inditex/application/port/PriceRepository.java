package com.rtornello.inditex.application.port;

import com.rtornello.inditex.infraestructure.output.data.PriceData;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceData, Serializable> {

    List<PriceData> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        Integer product, Integer brandId, LocalDateTime endDate, LocalDateTime startDate);


}
