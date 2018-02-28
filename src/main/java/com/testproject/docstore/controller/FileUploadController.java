package com.testproject.docstore.controller;

import com.testproject.docstore.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload")
public class FileUploadController {

    private DocService docService;

    @GetMapping
    public String upload() {
        return "upload";
    }

    @PostMapping(consumes = "multipart/form-data")
    public String doUpload(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description) {

        docService.saveDocument(name, null, file.getSize(), description);
        return "upload";
    }

    @Autowired
    public void setDocService(DocService docService) {
        this.docService = docService;
    }
}
