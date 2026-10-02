package com.ismarianto.warehousemanagement.dto;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class GlobalResponse<T> {

    private T data;
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String error;

    public GlobalResponse(
            T data,
            String message,
            HttpStatus status,
            LocalDateTime timestamp
    ) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.error = null;
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