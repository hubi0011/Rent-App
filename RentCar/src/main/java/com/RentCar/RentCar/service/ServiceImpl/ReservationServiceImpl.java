package com.RentCar.RentCar.service.ServiceImpl;

import com.RentCar.RentCar.dto.ReservationDto;
import com.RentCar.RentCar.entity.Car;
import com.RentCar.RentCar.entity.Reservation;
import com.RentCar.RentCar.entity.User;
import com.RentCar.RentCar.mapper.ReservationMapper;
import com.RentCar.RentCar.repository.CarRepository;
import com.RentCar.RentCar.repository.ReservationRepository;
import com.RentCar.RentCar.repository.UserRepository;
import com.RentCar.RentCar.service.ReservationService;
import com.RentCar.RentCar.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private CarRepository carRepository;

    private UserRepository userRepository;



    public ReservationServiceImpl(ReservationRepository reservationRepository, CarRepository carRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void createReservation(ReservationDto reservationDto,String carUrl) {

        String email = SecurityUtils.getCurrentUser().getUsername();


        User user=userRepository.findByEmail(email);

        Car car = carRepository.findByUrl(carUrl).get();

        Reservation reservation=ReservationMapper.mapToReservation(reservationDto);

        reservation.setStartDate(reservationDto.getStartDate());
        reservation.setEndDate(reservationDto.getEndDate());
        reservation.setTotalCost(reservationDto.getTotalCost());

        reservation.setCar_id(car);
        reservation.setUser_id(user);

        reservationRepository.save(reservation);
    }
    public boolean isCarAvailableForReservation(Long carId, LocalDate startDate, LocalDate endDate) {

        Car car = carRepository.findById(carId).orElse(null);

        if (car == null) {
            return false;
        }

        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(car, startDate, endDate);

        return overlappingReservations.isEmpty();
    }

    @Override
    public List<Reservation> getUserReservationsByUserId(Long id) {
        return reservationRepository.findByUserId(id);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
//    public List<Car> searchCars(String query) {
//        return reservationRepository.searchCars(query);
//    }


}





