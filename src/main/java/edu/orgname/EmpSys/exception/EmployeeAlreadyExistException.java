package edu.orgname.EmpSys.exception;

public class EmployeeAlreadyExistException extends RuntimeException{

    public EmployeeAlreadyExistException(String message){
        super(message);
    }
}
