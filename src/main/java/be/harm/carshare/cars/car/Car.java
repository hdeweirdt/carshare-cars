package be.harm.carshare.cars.car;

import lombok.Builder;
import org.springframework.data.annotation.Id;

@Builder
public class Car {

    @Id
    public Long id;

    private Long ownerId;

    public String name;

    public String brand;

    public String type;

    public int numberOfSeats;

    public FuelType fuelType;

    public boolean hasGPS;



}
