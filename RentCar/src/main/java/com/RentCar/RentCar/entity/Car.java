package com.RentCar.RentCar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Getter
@Setter
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String url;
    @NotNull
    private String mark;
    @NotNull
    private String model;
    @NotNull
    private int price;
    @NotNull
    private int horsepower;
    @NotNull
    private String description;
    @NotNull
    private String fuel;
    @NotNull
    private String location;
    @NotNull
    private String bodyType;
    @NotNull
    private String fuelType;
    @NotNull
    private int doorsNumber;
    @NotNull
    private int seatsNumber;
    @NotNull
    private String color;
    @NotNull
    private int productionYear;

    @OneToMany(mappedBy = "car_id" ,cascade = CascadeType.REMOVE)
    private List<Reservation> reservations = new ArrayList<>();


}
