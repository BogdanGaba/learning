package com.testproject.docstore.service;

import com.testproject.docstore.dto.DocDTO;

import java.util.List;

public interface DocService {

    DocDTO getById(String id);

    void saveDocument(String storageFileId, String name, String originalName, long size, String Description);

    void removeDocument(String id);

    List<DocDTO> getAll();
}
