package be.harm.carshare.cars.car;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import org.springframework.data.annotation.Id;

@Builder
public class Car {

    @Id
    @ApiModelProperty(value = "ID of the car.", required = true, example = "1L")
    public Long id;

    @ApiModelProperty(value = "ID of the owner of this car.", required = true, example = "1L")
    private Long ownerId;

    @ApiModelProperty(value = "Name of the car", required = true)
    public String name;

    @ApiModelProperty(value = "Brand of the car", required = true, example = "Suzuki")
    public String brand;

    @ApiModelProperty(value = "Model of the car", required = true, example = "Alto")
    public String model;

    @ApiModelProperty(value = "Number of seats in the car", required = true, example = "4")
    public int numberOfSeats;

    @ApiModelProperty(value = "Type of the fuel the car uses", required = true)
    public FuelType fuelType;

    @ApiModelProperty(value = "Whether or not the car is equipped with GPS", required = true)
    public boolean hasGPS;


}
