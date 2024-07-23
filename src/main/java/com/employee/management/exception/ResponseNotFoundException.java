package com.employee.management.exception;

import lombok.Getter;

                //custom exception class in Java to handle the case when a response is not found
@Getter
public class ResponseNotFoundException extends RuntimeException  {
    //ADD GETTER method to allow access to these fields outside the class.
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResponseNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

}
