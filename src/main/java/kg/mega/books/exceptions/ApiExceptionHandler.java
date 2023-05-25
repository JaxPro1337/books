package kg.mega.books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NotFountBook.class})
    public ResponseEntity<?> NotFountBook(NotFountBook notFountBook){
        HttpStatus notFount = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
            notFountBook.getMessage(),
                notFount
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NotFountAuthor.class})
    public ResponseEntity<?> NotFountAuthor (NotFountAuthor notFountAuthor){
        HttpStatus notFount = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                notFountAuthor.getMessage(),
                notFount
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
