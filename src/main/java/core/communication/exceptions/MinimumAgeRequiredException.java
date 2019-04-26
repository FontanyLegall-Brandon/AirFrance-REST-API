package core.communication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinimumAgeRequiredException extends Exception {
    public MinimumAgeRequiredException() {
        super("Error : The minimal age to can register need to ba at least 18");
    }
}
