package com.demo.chat.exception;

import lombok.Data;

import java.util.Date;

@Data
public class AppError{
    private String reason;
    private Integer status;
    private Date timestamp;

    public AppError(String reason, Integer status) {
        this.reason = reason;
        this.status = status;
        timestamp = new Date();
    }
}
