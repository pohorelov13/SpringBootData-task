package demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderDoesNotExistException.class)
    public ResponseEntity<String> handleOrderDoesNotExist(OrderDoesNotExistException exception) {
        log.error("OrderDoesNotExistException occurred", exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ProductDoesNotExistException.class)
    public ResponseEntity<String> handleProductDoesNotExist(ProductDoesNotExistException exception) {
        log.error("ProductDoesNotExistException occurred", exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
