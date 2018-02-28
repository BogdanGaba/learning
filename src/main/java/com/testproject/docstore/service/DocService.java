package com.testproject.docstore.service;

import com.testproject.docstore.dto.DocDTO;

import java.util.List;

public interface DocService {

    void saveDocument(String name,String extension,  long size, String Description);

    void removeDocument(String id);

    List<DocDTO> getAll();
}
