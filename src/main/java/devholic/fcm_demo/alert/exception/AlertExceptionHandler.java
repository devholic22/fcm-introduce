package devholic.fcm_demo.alert.exception;

import devholic.fcm_demo.alert.exception.exceptions.ReceiverTokenNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AlertExceptionHandler {

    @ExceptionHandler(ReceiverTokenNotFoundException.class)
    public ResponseEntity<String> handleReceiverTokenNotFoundException(final ReceiverTokenNotFoundException e) {
        return getExceptionWithStatus(e, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<String> getExceptionWithStatus(final Exception exception, final HttpStatus status) {
        return ResponseEntity.status(status)
                .body(exception.getMessage());
    }
}
