package com.RentCar.RentCar.repository;


import com.RentCar.RentCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByUrl(String Url);

    @Override
    void deleteById(Long id);

    @Query("SELECT p from Car p WHERE " +
            " p.mark LIKE CONCAT('%', :query, '%') OR " +
            " p.model LIKE CONCAT('%', :query, '%')")
    List<Car> serachCars(String query);

}
