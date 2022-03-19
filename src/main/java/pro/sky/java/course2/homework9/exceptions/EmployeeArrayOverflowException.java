package pro.sky.java.course2.homework9.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeArrayOverflowException extends RuntimeException {
    public EmployeeArrayOverflowException(String message) {
        super(message);
    }
}