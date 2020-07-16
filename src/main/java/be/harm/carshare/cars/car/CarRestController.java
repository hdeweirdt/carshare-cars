package be.harm.carshare.cars.car;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    @ApiOperation(value = "Return all cars")
    public List<Car> getCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return a specific car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The car as it was registered.", response = Car.class),
            @ApiResponse(code = 404, message = "No car with the given id is currently registered.")
    })
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Optional<Car> foundCar = carService.findById(id);
        if (foundCar.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundCar.get(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Register a new car")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The car as it was registered.", response = Car.class),
            @ApiResponse(code = 400, message = "Invalid construction parameters were given.")
    })
    public ResponseEntity<Car> registerNewCar(@Valid @RequestBody Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            var savedCar = carService.saveCar(car);
            return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
        }
    }
}
