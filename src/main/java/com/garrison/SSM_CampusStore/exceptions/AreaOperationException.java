package com.garrison.SSM_CampusStore.exceptions;

public class AreaOperationException extends RuntimeException{
    private static final long serialVersionUID = -6797300262848206100L;
    public AreaOperationException(String msg){
        super(msg);
    }
}
