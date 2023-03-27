package com.rtornello.inditex.application.port.output;

import com.rtornello.inditex.infraestructure.adapters.output.data.PriceData;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceData, Serializable> {

    PriceData findById(Integer id);


}
