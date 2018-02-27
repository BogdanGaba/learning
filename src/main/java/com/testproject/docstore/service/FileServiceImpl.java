package com.testproject.docstore.service;

import com.testproject.docstore.dao.DocumentDAO;
import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.entity.DocEntity;
import com.testproject.docstore.entity.MetadataEntity;
import com.testproject.docstore.mapper.DocConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    private DocumentDAO documentDAO;

    @Override
    public void saveDocument(DocDTO docDTO) {
        documentDAO.save(DocConverter.toDocEntity(docDTO));
    }

    @Override
    public void removeDocument(String id) {

    }

    @Autowired
    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }
}
