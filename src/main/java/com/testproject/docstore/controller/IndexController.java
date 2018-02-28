package com.testproject.docstore.controller;

import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private DocService docService;

    @GetMapping
    public String index(HttpServletRequest request) {
        request.setAttribute("files", docService.getAll());
        return "index";
    }

    @Autowired
    public void setDocService(DocService docService) {
        this.docService = docService;
    }
}
