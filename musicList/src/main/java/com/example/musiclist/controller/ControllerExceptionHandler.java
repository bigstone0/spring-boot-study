package com.example.musiclist.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception e){
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().body("에상치 못한 오류");
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> rollbackException(UnexpectedRollbackException e){
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().body("데이터 처리를 정상적으로 완료하지 못했습니다.");
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> sqlintException(SQLIntegrityConstraintViolationException e){
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().body("무결정 제약 위반.");
    }
}
