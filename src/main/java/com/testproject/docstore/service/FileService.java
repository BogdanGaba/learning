package com.testproject.docstore.service;

import com.testproject.docstore.dto.DocDTO;

public interface FileService {

    void saveDocument(DocDTO docDTO);

    void removeDocument(String id);
}
