package be.harm.carshare.cars.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceMongoImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceMongoImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.insert(car);
    }
}
