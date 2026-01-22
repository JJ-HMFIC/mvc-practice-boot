package com.demo.comentostatistic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 숫자가 들어와야 하는데 문자가 들어왔을 때 (NumberFormatException 등)
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Map<String, String>> handleNumberFormatException(NumberFormatException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Bad Request");
        response.put("message", "숫자만 입력 가능합니다. 입력값을 확인해주세요."); // 예쁜 메시지

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 그 외 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Internal Server Error");
        response.put("message", "서버 오류가 발생했습니다: " + e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}