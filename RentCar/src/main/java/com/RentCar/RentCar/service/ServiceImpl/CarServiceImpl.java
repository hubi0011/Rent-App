package com.RentCar.RentCar.service.ServiceImpl;

import com.RentCar.RentCar.dto.CarDto;
import com.RentCar.RentCar.entity.Car;
import com.RentCar.RentCar.mapper.CarMapper;
import com.RentCar.RentCar.repository.CarRepository;
import com.RentCar.RentCar.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> findAllCars() {
        List<Car> posts = carRepository.findAll();
        return posts.stream().map(CarMapper::mapToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createCar(CarDto carDto) {
        Car car= CarMapper.mapToCar(carDto);
        carRepository.save(car);
    }

    @Override
    public CarDto findCarByID(Long ID) {
        Car car=carRepository.findById(ID).get();
        return CarMapper.mapToCarDto(car);
    }

    @Override
    public void updateCar(CarDto carDto) {
        Car car= CarMapper.mapToCar(carDto);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Long carID) {
        carRepository.deleteById(carID);
    }

    @Override
    public CarDto findCarByUrl(String carUrl) {
        Car car=carRepository.findByUrl(carUrl).get();
        return CarMapper.mapToCarDto(car);
    }

    @Override
    public List<CarDto> searchCar(String query) {
        List<Car> cars=carRepository.serachCars(query);
        return cars.stream().map(CarMapper::mapToCarDto)
                .collect(Collectors.toList());
    }

}
