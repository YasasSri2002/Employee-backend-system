package edu.orgname.EmpSys.exception.handeler;

import edu.orgname.EmpSys.Model.ErrorResponse;
import edu.orgname.EmpSys.exception.EmployeeAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GobalExeceptionHandeler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeAlreadyExistException(
            EmployeeAlreadyExistException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus("Failed");
        errorResponse.setErrorMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
