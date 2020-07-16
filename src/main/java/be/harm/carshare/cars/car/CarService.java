package be.harm.carshare.cars.car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();

    Optional<Car> findById(Long id);

    Car saveCar(Car Car);

}
