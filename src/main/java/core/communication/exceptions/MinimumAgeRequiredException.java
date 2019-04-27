package core.communication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for age, age > 18
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinimumAgeRequiredException extends Exception {
    public MinimumAgeRequiredException() {
        super("Error : The minimal age to can register must be above 18");
    }
}
