package com.testproject.docstore.controller;

import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.service.DocService;
import com.testproject.docstore.service.StorageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("upload")
public class FileUploadController {

    private DocService docService;
    private StorageService storageService;

    @GetMapping
    public String upload() {
        return "upload";
    }

    @PostMapping(consumes = "multipart/form-data")
    public String doUpload(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description) {
        String id = storageService.uploadFile(file);
        docService.saveDocument(id, name, file.getOriginalFilename(), file.getSize(), description);

        return "upload";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@RequestParam("id") String id) throws IOException {
        DocDTO docInfo = docService.getById(id);
        final InputStream in = storageService.read(docInfo.getStorageId());
        final HttpHeaders headers = new HttpHeaders();
        String fileName = docInfo.getName() + "." + docInfo.getExtension();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
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
