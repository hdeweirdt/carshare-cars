package be.harm.carshare.cars.car;

import be.harm.carshare.cars.util.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class CarModelListener extends AbstractMongoEventListener<Car> {
    private final SequenceGeneratorService sequenceGenerator;

    public CarModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Car> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(sequenceGenerator.generateSequence(Car.SEQUENCE_NAME));
        }
    }
}
