package com.galete.travel.requests.tour.management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TourManagementRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "The image uri input is required")
    @Size(min = 5, max = 100, message = "The image uri length: min = 5 and max = 100")
    private String imageUri;
    @NotBlank(message = "The country input is required")
    @Size(min = 2, max = 30, message = "The country length: min = 2 and max = 30")
    private String country;
    @NotBlank(message = "The district input is required")
    @Size(min = 2, max = 30, message = "The district length: min = 2 and max = 30")
    private String district;
    @NotBlank(message = "The destination input is required")
    @Size(min = 5, max = 100, message = "The destination length: min = 5 and max = 100")
    private String destination;
    @NotBlank(message = "The description input is required")
    @Size(min = 5, max = 500, message = "The description length: min = 5 and max = 500")
    private String description;
    @NotBlank(message = "The introduction input is required")
    @Size(min = 5, max = 200, message = "The introduction length: min = 5 and max = 200")
    private String introduction;
    @FutureOrPresent(message = "The check in must be present or future")
    private LocalDate checkIn;
    @Future(message = "The check out must be future")
    private LocalDate checkOut;
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be a value greater than zero")
    @DecimalMax(value = "100000.00", inclusive = false, message = "Price must be less than one hundred thousand")
    @Digits(integer = 6, fraction = 2, message = "Invalid informed format")
    private BigDecimal price;
    @NotNull(message = "Promotion input is required")
    private Boolean promotion;
}
