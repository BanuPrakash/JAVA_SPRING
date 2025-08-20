package com.adobe.prj.dao;

public class PersitenceException extends  Exception{
    public PersitenceException() {
    }

    public PersitenceException(String message) {
        super(message);
    }

    public PersitenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
