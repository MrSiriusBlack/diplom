package su.itline.diploma.errors;

public class TimeExpiredError extends RuntimeException {

    private final static String MESSAGE = "Expired voting time";

    public TimeExpiredError() {
        super(MESSAGE);
    }
}
