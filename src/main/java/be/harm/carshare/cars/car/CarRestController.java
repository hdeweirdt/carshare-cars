package be.harm.carshare.cars.car;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public List<Car> getCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Car registerNewCar(@Valid @RequestBody Car Car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        } else {
            return carService.saveCar(Car);
        }
    }
}
