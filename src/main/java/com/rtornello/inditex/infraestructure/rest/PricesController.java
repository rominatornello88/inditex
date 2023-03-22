package com.rtornello.inditex.infraestructure.rest;


import com.rtornello.inditex.application.interfaces.PriceService;
import com.rtornello.inditex.infraestructure.rest.dto.PriceDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PricesController {

    private final PriceService priceService;

    public PricesController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/testing")
    public ResponseEntity<String> testing() {
        return new ResponseEntity<>("testing", HttpStatus.OK);
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<PriceDto> getUserById(@PathVariable UUID id) {
        return new ResponseEntity<>(priceService.getPrice(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PriceDto> saveUser(@RequestBody PriceDto priceDto) {
        return new ResponseEntity<>(
            priceService.savePrice(priceDto),
            HttpStatus.CREATED);
    }

}
