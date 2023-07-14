package com.RentCar.RentCar.controller;

import com.RentCar.RentCar.dto.CarDto;
import com.RentCar.RentCar.dto.ReservationDto;
import com.RentCar.RentCar.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class RentCarController {
    private CarService carService;

    public RentCarController(CarService carService) {
        this.carService = carService;
    }

    // handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewRentCar(Model model) {
        List<CarDto> carResponse = carService.findAllCars();
        model.addAttribute("carResponse", carResponse);
        return "rentCar/rentCar";
    }

    //handler method to handle view car request
    @GetMapping("/car/{carUrl}")
    private String showCar(@PathVariable("carUrl") String carUrl,
                           Model model) {
        CarDto car = carService.findCarByUrl(carUrl);

        ReservationDto reservationDto = new ReservationDto();
        model.addAttribute("reservation", reservationDto);
        reservationDto.setTotalCost(BigDecimal.valueOf(car.getPrice()));
        model.addAttribute("car", car);
        return "rentCar/view_car";
    }

    //    handler method to handle search cars by Mark and model
    @GetMapping("/cars/search")
    public String searchCars(@RequestParam(value = "query")
                             String query, Model model) {
        List<CarDto> cars = carService.searchCar(query);
        model.addAttribute("cars", cars);
        return "rentCar/rentCar";
    }

}