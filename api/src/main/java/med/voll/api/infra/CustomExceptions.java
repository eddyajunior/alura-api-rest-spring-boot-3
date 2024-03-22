package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptions
{
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity CustomError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity CustomError400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationDataError::new).toList());
    }

    private record ValidationDataError(String field, String message){
        public ValidationDataError(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
