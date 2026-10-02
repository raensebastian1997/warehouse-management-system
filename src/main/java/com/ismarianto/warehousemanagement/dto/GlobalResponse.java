package com.ismarianto.warehousemanagement.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GlobalResponse<T> {

    private T data;
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String error;


    public GlobalResponse(T data, String message, HttpStatus status) {
        this(data, message, status, null);
    }


    public GlobalResponse(T data, String message, HttpStatus status, String error) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "GlobalResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                ", error='" + error + '\'' +
                '}';
    }
}