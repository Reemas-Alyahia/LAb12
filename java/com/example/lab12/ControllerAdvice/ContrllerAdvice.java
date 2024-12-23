package com.example.lab12.ControllerAdvice;

import com.example.lab12.ApiResponse.ApiException;
import com.example.lab12.ApiResponse.ApiResponse;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ContrllerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleApiException(ApiException ex) {
        // إرجاع الرسالة الخاصة بالاستثناء مع كود حالة HTTP 400
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> IllegalArgumentException(IllegalArgumentException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiResponse> NullPointerException(NullPointerException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    @ExceptionHandler(value = JpaSystemException.class)
    public ResponseEntity<ApiResponse> JpaSystemException(JpaSystemException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    @ExceptionHandler(value = MissingPathVariableException.class)
    public ResponseEntity<ApiResponse> MissingPathVariableException(MissingPathVariableException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    @ExceptionHandler(value = ObjectOptimisticLockingFailureException.class)
    public ResponseEntity<ApiResponse> ObjectOptimisticLockingFailureException(ObjectOptimisticLockingFailureException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity<ApiResponse> InvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ResponseEntity<ApiResponse> UnexpectedTypeException(UnexpectedTypeException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> ApiException(ApiException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<ApiResponse> NoResourceFoundException(NoResourceFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

}
