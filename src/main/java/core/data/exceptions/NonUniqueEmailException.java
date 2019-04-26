package core.data.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonUniqueEmailException  extends Exception{
    public NonUniqueEmailException() {
        super("Error : The email adress need to be Unique");
    }
}
