package com.dungken.SpringRestfullAPI.exception;

import com.dungken.SpringRestfullAPI.entity.ErrorResponse;

public class SinhVienException extends RuntimeException {
    public SinhVienException(String message) {
        super(message);
    }
}
