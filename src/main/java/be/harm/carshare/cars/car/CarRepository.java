package be.harm.carshare.cars.car;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, Long> {

    Optional<Car> findById(Long id);
}
