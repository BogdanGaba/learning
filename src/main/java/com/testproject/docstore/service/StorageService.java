package com.testproject.docstore.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface StorageService {

    String uploadFile(MultipartFile multipartFile);

    void removeFile(String storageId);

    InputStream read(String storageId);
}
