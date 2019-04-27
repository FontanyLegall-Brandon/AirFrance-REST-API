package core.communication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for bad geographic location, only people form France can register !
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadGeographicLocationException extends Exception{
    public BadGeographicLocationException() {
        super("Error : Only French peoples are allowed to register");
    }
}
