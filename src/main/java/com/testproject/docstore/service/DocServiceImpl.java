package com.testproject.docstore.service;

import com.testproject.docstore.dao.DocumentDAO;
import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.entity.DocEntity;
import com.testproject.docstore.entity.MetadataEntity;
import com.testproject.docstore.mapper.DocConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DocServiceImpl implements DocService {

    private DocumentDAO documentDAO;

    @Override
    public void saveDocument(String name,String extension,  long size, String description) {
        documentDAO.save(buildEntity(name, extension,size,description));
    }

    @Override
    public void removeDocument(String id) {
        documentDAO.removeById(id);
    }

    @Override
    public List<DocDTO> getAll() {
       return documentDAO.getAll().stream().map(DocConverter::toDocDTO).collect(Collectors.toList());
    }

    @Autowired
    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    private DocEntity buildEntity(String name,String extension,  long size, String description) {
        DocEntity docEntity = new DocEntity();
        docEntity.setName(name);
        docEntity.setExtension(extension);
        docEntity.setSize(size);

        MetadataEntity metadataEntity = new MetadataEntity();

        metadataEntity.setDocEntity(docEntity);
        docEntity.setMetadataEntity(metadataEntity);
        metadataEntity.setDescription(description);


        return docEntity;
    }
}
