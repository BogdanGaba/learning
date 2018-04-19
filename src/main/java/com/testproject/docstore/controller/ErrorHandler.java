package com.testproject.docstore.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public String handler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("message", e.getMessage());
        return "error";
    }
}
