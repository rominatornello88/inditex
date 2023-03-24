package com.rtornello.inditex.infraestructure.data;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID id;

    @Column(name = "start_date")
    @NotNull
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @NotNull
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
    private Brand brand;

    @ManyToOne
    @NotNull
    private Product product;


}
