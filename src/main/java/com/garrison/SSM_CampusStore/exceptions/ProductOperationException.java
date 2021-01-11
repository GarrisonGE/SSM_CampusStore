package com.garrison.SSM_CampusStore.exceptions;

public class ProductOperationException extends RuntimeException{
    private static final long serialVersionUID = 3954310238970274076L;
    public ProductOperationException(String msg){
        super(msg);
    }
}
