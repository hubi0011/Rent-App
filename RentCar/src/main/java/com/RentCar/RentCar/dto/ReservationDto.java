package com.RentCar.RentCar.dto;


import com.RentCar.RentCar.entity.Car;
import com.RentCar.RentCar.entity.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDto {


    private Long id;
    private User user;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalCost;
}
