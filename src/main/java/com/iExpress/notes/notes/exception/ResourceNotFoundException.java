package com.iExpress.notes.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;


    public ResourceNotFoundException(String user, String fldNm, Long fldVal) {
        super(String.format("%s not found with %s : '%s'", user, fldNm, fldVal));
        this.resourceName = user;
        this.fieldName = fldNm;
        this.fieldValue = fldVal;
    }

    public ResourceNotFoundException(String user, String fldNm, String fldVal) {
        super(String.format("%s not found with %s : '%s'", user, fldNm, fldVal));
        this.resourceName = user;
        this.fieldName = fldNm;
        this.fieldValue = fldVal;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}
