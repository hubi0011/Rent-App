package com.RentCar.RentCar.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {


    private Long ID;
    private String url;
    @NotEmpty(message = "Price should not be empty or null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Price should only contain letters")
    private String mark;

    @NotEmpty(message = "Model should not be empty or null")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Model should only contain letters")
    private String model;

    @NotNull(message = "price should not be null")
    @Min(value = 1, message = "Price should be a positive number")
    private int price;
    @NotNull(message = "Horsepower should not be null")
    @Min(value = 1, message = "Horsepower should be a positive number")
    private int horsepower;

    @NotEmpty(message = "Description should not be empty or null")
    private String description;

    @Pattern(regexp = "(?i)^(electric|diesel|gasoline|hybrid)$", message = "Invalid fuel type")
    @NotEmpty(message = "fuel should not be empty or null")
    private String fuel;

    @NotEmpty(message = "Location should not be empty or null")
    private String location;

    @NotEmpty(message = "Body type should not be empty or null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Body type should only contain letters")
    private String bodyType;

    @NotEmpty(message = "Fuel type should not be empty or null")
    @Pattern(regexp = "(?i)^(electric|diesel|gasoline|hybrid)$", message = "Invalid fuel type")
    private String fuelType;
    @NotNull(message = "Doors number should not be null")
    @Min(value = 1, message = "Doors number should be between 1 and 10")
    @Max(value = 10, message = "Doors number should be between 1 and 10")
    private int doorsNumber;
    @NotNull(message = "Seats number should not be null")
    @Min(value = 1, message = "Seats number should be between 1 and 10")
    @Max(value = 10, message = "Seats number should be between 1 and 10")
    private int seatsNumber;
    @NotEmpty(message = "Color  should not be empty or null")
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "Color should only contain letters and have a minimum length of 5")
    private String color;
    @NotNull(message = "Production year should not be null")
    @Min(value = 1900, message = "Invalid production year")
    @Max(value = 2024, message = "Invalid production year")
    private int productionYear;
}
