package com.example.exception;

public class CustomerNotFoundException extends RuntimeException {

    private String msg;

    public CustomerNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
