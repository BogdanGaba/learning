package com.testproject.docstore.mapper;

import com.testproject.docstore.dto.DocDTO;
import com.testproject.docstore.entity.DocEntity;

public final class DocConverter {

    private DocConverter() {
        throw new UnsupportedOperationException();
    }

    public static DocDTO toDocDTO(DocEntity docEntity) {
        DocDTO dto = new DocDTO();
        dto.setExtension(docEntity.getExtension());
        dto.setSize(docEntity.getSize());
        dto.setName(docEntity.getName());
        dto.setId(docEntity.getId());
        dto.setStorageId(docEntity.getStorageId());

        dto.setMetadata(MetadataConverter.toMetadataDTO(docEntity.getMetadataEntity()));
        return dto;
    }

    public static DocEntity toDocEntity(DocDTO docDTO) {
        DocEntity entity = new DocEntity();
        entity.setId(docDTO.getId());
        entity.setExtension(docDTO.getExtension());
        entity.setName(docDTO.getName());
        entity.setSize(docDTO.getSize());
        entity.setStorageId(docDTO.getStorageId());

        entity.setMetadataEntity(MetadataConverter.toMetadataEntity(docDTO.getMetadata()));
        entity.getMetadataEntity().setDocEntity(entity);
        return entity;
    }
}
