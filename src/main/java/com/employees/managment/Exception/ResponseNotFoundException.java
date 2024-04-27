package com.employees.managment.Exception;


import lombok.Getter;

//custom exception class in Java to handle the case when a response is not found
@Getter
public class ResponseNotFoundException extends RuntimeException  {
    //ADD GETTER method to allow access to these fields outside the class.
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResponseNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

}
