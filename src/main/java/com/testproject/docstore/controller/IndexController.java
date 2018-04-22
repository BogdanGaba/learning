package com.testproject.docstore.controller;

import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.service.DocService;
import com.testproject.docstore.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    private DocService docService;
    private StorageService storageService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(HttpServletRequest request) {
        request.setAttribute("docs", docService.getAll());
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id) {
        storageService.removeFile(docService.getById(id).getStorageId());
        docService.removeDocument(id);
        return "redirect:/";
    }

    @Autowired
    public void setDocService(DocService docService) {
        this.docService = docService;
    }

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
