package core.communication.exceptions;

import core.data.User;
import org.junit.Test;

public class InvalidPhoneNumberTest {

    @Test(expected = InvalidPhoneNumberException.class)
    public void exceptionTest() throws InvalidEmailException, InvalidPhoneNumberException, EmptyFieldException, MinimumAgeRequiredException, BadGeographicLocationException {
        new User("test","test@test.fr","abcd","01/01/2000","france",null,"1234");
    }
}