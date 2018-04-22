package com.testproject.docstore.controller;

import com.testproject.docstore.exceptions.FileUploadException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({Exception.class, FileUploadException.class})
    public String handler(Exception e, HttpServletRequest request) {
        request.setAttribute("message", e.getMessage());
        return "error";
    }
}
