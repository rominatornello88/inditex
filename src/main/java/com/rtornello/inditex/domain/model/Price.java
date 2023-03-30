package com.rtornello.inditex.domain.model;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priceList;
    private Integer priority;
    private Float price;
    private String currency;
    private Integer brandId;
    private Integer productId;

}
