package be.harm.carshare.cars.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Required for the automated generation of ID's.
 *
 * @see <a href="https://www.baeldung.com/spring-boot-mongodb-auto-generated-field">https://www.baeldung.com/spring-boot-mongodb-auto-generated-field</a>.
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    @Getter
    private long seq;
}

