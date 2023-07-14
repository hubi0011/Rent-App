package com.RentCar.RentCar.mapper;


import com.RentCar.RentCar.dto.CarDto;
import com.RentCar.RentCar.entity.Car;

public class CarMapper {
    //map Car entity to CarDto
    public static CarDto mapToCarDto(Car car) {
        return CarDto.builder().
                ID(car.getID())
                .mark(car.getMark())
                .model(car.getModel())
                .price(car.getPrice())
                .horsepower(car.getHorsepower())
                .description(car.getDescription())
                .fuel(car.getFuel())
                .location(car.getLocation())
                .bodyType(car.getBodyType())
                .fuelType(car.getFuelType())
                .seatsNumber(car.getSeatsNumber())
                .color(car.getColor())
                .productionYear(car.getProductionYear())
                .url(car.getUrl())
                .doorsNumber(car.getDoorsNumber())
                .build();
    }

    //map CarDto to Car entity
    public static Car mapToCar(CarDto carDto) {
        return Car.builder()
                .ID(carDto.getID())
                .mark(carDto.getMark())
                .model(carDto.getModel())
                .price(carDto.getPrice())
                .horsepower(carDto.getHorsepower())
                .description(carDto.getDescription())
                .fuel(carDto.getFuel())
                .location(carDto.getLocation())
                .bodyType(carDto.getBodyType())
                .fuelType(carDto.getFuelType())
                .seatsNumber(carDto.getSeatsNumber())
                .color(carDto.getColor())
                .productionYear(carDto.getProductionYear())
                .url(carDto.getUrl())
                .doorsNumber(carDto.getDoorsNumber())
                .build();
    }

}
