package com.example.exception;

public class InvalidChannelException extends RuntimeException {
	
	  public InvalidChannelException(String message) {
	        super(message);
	    }
	    
	    public InvalidChannelException(String message, Throwable cause) {
	        super(message, cause);
	    }
	   
}
