package com.RentCar.RentCar.repository;

import com.RentCar.RentCar.entity.Car;
import com.RentCar.RentCar.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.car_id = :car AND (:endDate >= r.startDate AND :startDate <= r.endDate)")
    List<Reservation>
    findOverlappingReservations(@Param("car")
                                Car car, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT r FROM Reservation r JOIN r.user_id u WHERE u.id = :id")
    List<Reservation> findByUserId(@Param("id") Long id);

    void deleteById(Long id);


}
