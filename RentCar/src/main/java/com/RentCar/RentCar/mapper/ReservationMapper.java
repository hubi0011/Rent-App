package com.RentCar.RentCar.mapper;

import com.RentCar.RentCar.dto.ReservationDto;
import com.RentCar.RentCar.entity.Reservation;

public class ReservationMapper {
    //convert Reservation entity to reservationDto
    public static ReservationDto mapToReservationDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .totalCost(reservation.getTotalCost())
                .build();
    }

    //convert ReservationDto  to reservation entity
    public static Reservation mapToReservation(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .totalCost(reservationDto.getTotalCost())
                .build();
    }
}
