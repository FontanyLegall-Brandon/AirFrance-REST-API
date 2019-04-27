package core.communication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception when the input email as not a email
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Error : Invalid email input");
    }
}
