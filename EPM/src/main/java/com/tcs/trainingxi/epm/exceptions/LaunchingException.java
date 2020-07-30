package com.tcs.trainingxi.epm.exceptions;

public class LaunchingException extends AssertionError{

    public LaunchingException(String message, Throwable throwable){
        super(message,throwable);
    }

}
