package core.data.exceptions;

public class MinimumAgeRequiredException extends Exception {
    public MinimumAgeRequiredException() {
        super("Error : The minimal age to can register need to ba at least 18");
    }
}
