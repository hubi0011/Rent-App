package com.RentCar.RentCar.controller;


import com.RentCar.RentCar.dto.CarDto;
import com.RentCar.RentCar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
public class CarController {


    private CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    //create handler method, get request and return model and view
    @GetMapping("/admin/cars")
    public String cars(Model model) {
        List<CarDto> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "admin/cars";
    }

    //handler method to handle new car request
    @GetMapping("admin/cars/newcar")
    public String newPostForm(Model model) {
        CarDto carDto = new CarDto();
        model.addAttribute("car", carDto);
        return "admin/create_car";
    }

    //handler method to handle create car
    @PostMapping("/admin/cars")
    public String createCar(@Valid @ModelAttribute("car") CarDto carDto,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("car", carDto);
            return "admin/create_car";
        }
        carDto.setUrl(generateUrl(carDto.getMark(), carDto.getModel(), carDto.getProductionYear()));
        carService.createCar(carDto);
        return "redirect:/admin/cars";
    }

    //handler method to handle edit post request
    @GetMapping("/admin/cars/{carID}/edit")
    public String editPostForm(@PathVariable("carID") String carID,
                               Model model) {
        Long carIdLong = Long.parseLong(carID);

        CarDto carDto = carService.findCarByID(carIdLong);
        model.addAttribute("car", carDto);
        return "admin/edit_car";
    }

    //handler method to sumbmit edit cars request
    @PostMapping("/admin/cars/{carID}")
    public String updateCar(@PathVariable("carID") Long carID,
                            @Valid @ModelAttribute("car") CarDto car,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("car", car);
            return "admin/edit_car";
        }
        car.setID(carID);
        carService.updateCar(car);
        return "redirect:/admin/cars";

    }

    // handler method to handle delete car request
    @GetMapping("/admin/cars/{carID}/delete")
    public String deleteCar(@PathVariable("carID") Long carID) {
        carService.deleteCar(carID);
        return "redirect:/admin/cars";
    }

    //handler method to handle view car request
    @GetMapping("/admin/cars/{carUrl}/view")
    private String showCar(@PathVariable("carUrl") String carUrl,
                           Model model) {
        CarDto cars = carService.findCarByUrl(carUrl);
        model.addAttribute("cars", cars);
        return "admin/view_car";

    }

    //handler method to handle search cars request
    @GetMapping("/admin/cars/search")
    public String searchCars(@RequestParam(value = "query")
                             String query, Model model) {
        List<CarDto> cars = carService.searchCar(query);
        model.addAttribute("cars", cars);
        return "admin/cars";
    }

    //method to generate url
    private static String generateUrl(String mark, String model, int productionYear) {
        String url = mark.toLowerCase().replace(" ", "-") + "-" +
                model.toLowerCase().replace(" ", "-") + "-" + productionYear + "-";

        UUID uuid = UUID.randomUUID();
        String randomString = uuid.toString().replace("-", "").substring(0, 8);

        url += randomString;
        return url;
    }

}
