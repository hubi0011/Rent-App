package com.RentCar.RentCar.service;

import com.RentCar.RentCar.dto.ReservationDto;
import com.RentCar.RentCar.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void createReservation(ReservationDto reservationDto, String carUrl);

    boolean isCarAvailableForReservation(Long carId, LocalDate startDate, LocalDate endDate);

    List<Reservation> getUserReservationsByUserId(Long id);

    void deleteReservation(Long id);


    Reservation getReservationById(Long id);

//    List<Car> searchCars(String query);

}
