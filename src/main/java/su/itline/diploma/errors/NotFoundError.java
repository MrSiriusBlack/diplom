package su.itline.diploma.errors;

import javax.validation.constraints.NotNull;

public class NotFoundError extends RuntimeException {

    private final static String MESSAGE = "Object %s not found by id %s";

    public NotFoundError(@NotNull Class objectClass, @NotNull Number id) {
        super(String.format(MESSAGE, objectClass, id));
    }
}
