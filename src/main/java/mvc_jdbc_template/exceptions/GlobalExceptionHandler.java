package mvc_jdbc_template.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import mvc_jdbc_template.response.EntityResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<EntityResponse> handleStudentNotFoundException(StudentNotFoundException ex){
        EntityResponse entityResponse=new EntityResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(entityResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EntityResponse> handleGenericException(Exception ex){
        EntityResponse entityResponse=new EntityResponse("Internal Server Error:"+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(entityResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
