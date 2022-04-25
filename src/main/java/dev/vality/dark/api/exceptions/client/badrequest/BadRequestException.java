package dev.vality.dark.api.exceptions.client.badrequest;

import dev.vality.dark.api.exceptions.client.DarkApi4xxException;
import lombok.Getter;

@Getter
public class BadRequestException extends DarkApi4xxException {

    private final Object response;

    public BadRequestException(String message, Throwable cause, Object response) {
        super(message, cause);
        this.response = response;
    }

    public BadRequestException(String message, Object response) {
        super(message);
        this.response = response;
    }
}
