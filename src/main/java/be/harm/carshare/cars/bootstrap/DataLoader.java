package be.harm.carshare.cars.bootstrap;

import be.harm.carshare.cars.car.Car;
import be.harm.carshare.cars.car.CarService;
import be.harm.carshare.cars.car.FuelType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final CarService carService;

    public DataLoader(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void run(String... args) {
        if (carService.findAll().isEmpty()) {
            saveDefaultCars();
        }
    }

    private void saveDefaultCars() {
        carService.saveCar(Car.builder()
                .id(1L)
                .name("BMWeetje")
                .brand("Suzuki")
                .numberOfSeats(4)
                .fuelType(FuelType.PETROL95)
                .type("Alto")
                .build());
        carService.saveCar(Car.builder()
                .id(2L)
                .name("De groten")
                .fuelType(FuelType.DIESEL)
                .numberOfSeats(4)
                .brand("Kia")
                .hasGPS(true)
                .type("Venga")
                .build());
    }


}
