package com.rtornello.inditex.infraestructure.output.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
@Getter
@Setter
public class PriceData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "start_date")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    @NotNull
    private String priceList;

    @Column(name = "priority")
    @NotNull
    private String priority;

    @Column(name = "price")
    @NotNull
    private Float price;

    @Column(name = "currency")
    @NotNull
    private String currency;

    @ManyToOne
    @NotNull
    private BrandData brand;

    @ManyToOne
    @NotNull
    private ProductData product;


}
