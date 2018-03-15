package com.testproject.docstore.service;

import com.testproject.docstore.exceptions.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService {

    //    private final String STORAGE_PATH = "/home/gabik/storage"; // linux
    private final String STORAGE_PATH = "d:\\storage"; // windows

    private final String DELIMITER = File.separator;

    private final static Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String storageFileId = UUID.randomUUID().toString().replace("-", "");
        try {
            try (OutputStream file = new FileOutputStream(STORAGE_PATH + DELIMITER + storageFileId)) {
                FileCopyUtils.copy(multipartFile.getInputStream(), file);
            }
        } catch (IOException e) {
            LOGGER.error("Error ocured during file uploading", e);
            throw new FileUploadException("Can't upload file", e);
        }

        return storageFileId;
    }

    @Override
    public void removeFile(String storageId) {
        new File(STORAGE_PATH + DELIMITER + storageId).delete();
    }

    @Override
    public InputStream read(String storageId) {
        try {
            return new FileInputStream(STORAGE_PATH + DELIMITER + storageId);
        } catch (IOException e) {
            throw new FileUploadException("Error reading file", e);
        }
    }
}
