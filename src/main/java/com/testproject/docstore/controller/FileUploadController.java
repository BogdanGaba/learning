package com.testproject.docstore.controller;

import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.dto.MetadataDTO;
import com.testproject.docstore.service.FileService;
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

    private FileService fileService;

    @GetMapping
    public String upload() {
        return "upload";
    }

    @PostMapping(consumes = "multipart/form-data")
    public String doUpload(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description) {

        DocDTO dto = new DocDTO();
        dto.setName(name);
        dto.setSize(file.getSize());

        MetadataDTO metadataDTO = new MetadataDTO();
        metadataDTO.setDescription(description);
        dto.setMetadata(metadataDTO);
//TODO move dto building to service
        fileService.saveDocument(dto);
        return "upload";
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
