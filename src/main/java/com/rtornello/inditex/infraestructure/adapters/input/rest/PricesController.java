package com.rtornello.inditex.infraestructure.adapters.input.rest;


import com.rtornello.inditex.application.interfaces.PriceService;
import com.rtornello.inditex.domain.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/prices", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PricesController {

    private final PriceService priceService;

    public PricesController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping("/t")
    public ResponseEntity<Price> getPriceById(@RequestParam("date") String dateTime, @RequestParam("productId") Integer productId, @RequestParam("brandId") Integer brandId) {
        log.info("REST Get Price By Id ");
        return new ResponseEntity<>(priceService.getPrice(dateTime, productId, brandId), HttpStatus.OK);
    }


}
