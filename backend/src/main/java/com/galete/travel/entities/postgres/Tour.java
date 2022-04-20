package com.galete.travel.entities.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tb_tour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    @SequenceGenerator(name = "tour_id_sequence", sequenceName = "tour_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_id_sequence")
    private Long id;
    @Column(nullable = false)
    private String imageUri;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private String introduction;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private LocalDate checkIn;
    @Column(nullable = false)
    private LocalDate checkOut;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;
    @Column(nullable = false)
    private Boolean promotion = false;
    @Column(columnDefinition = "integer default 0")
    private Integer reviews;
    @Column(columnDefinition = "double default 0.0")
    private Double stars;
}
