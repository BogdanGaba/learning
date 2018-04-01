package com.testproject.docstore.service;

import com.testproject.docstore.dao.DocumentRepository;
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

    private DocumentRepository documentRepository;

    @Override
    public DocDTO getById(String id) {
        return documentRepository.getById(id).map(DocConverter::toDocDTO).get();
    }

    @Override
    public void saveDocument(String storageId, String name, String originalName, long size, String description) {
        documentRepository.save(buildEntity(storageId, name, getExtension(originalName), size, description));
    }

    @Override
    public void removeDocument(String id) {
        documentRepository.removeById(id);
    }

    @Override
    public List<DocDTO> getAll() {
        return documentRepository.getAll().stream().map(DocConverter::toDocDTO).collect(Collectors.toList());
    }

    @Autowired
    public void setDocumentRepository(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    private DocEntity buildEntity(String storageId, String name, String extension, long size, String description) {
        DocEntity docEntity = new DocEntity();
        docEntity.setName(name);
        docEntity.setExtension(extension);
        docEntity.setSize(size);
        docEntity.setStorageId(storageId);

        MetadataEntity metadataEntity = new MetadataEntity();

        metadataEntity.setDocEntity(docEntity);
        docEntity.setMetadataEntity(metadataEntity);
        metadataEntity.setDescription(description);

        return docEntity;
    }

    private String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return fileName.substring(dotIndex + 1);
    }
}
