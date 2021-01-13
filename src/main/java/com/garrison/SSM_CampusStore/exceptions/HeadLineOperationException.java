package com.garrison.SSM_CampusStore.exceptions;

public class HeadLineOperationException extends RuntimeException{
    private static final long serialVersionUID = 157303963261102250L;
    public HeadLineOperationException(String msg) {
        super(msg);
    }
}
