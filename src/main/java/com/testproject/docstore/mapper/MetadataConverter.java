package com.testproject.docstore.mapper;

import com.testproject.docstore.dto.MetadataDTO;
import com.testproject.docstore.entity.MetadataEntity;

public final class MetadataConverter {

    private MetadataConverter() {
        throw new UnsupportedOperationException();
    }

    public static MetadataDTO toMetadataDTO(MetadataEntity metadataEntity) {
        MetadataDTO dto = new MetadataDTO();
        dto.setDescription(metadataEntity.getDescription());

        return dto;
    }

    public static MetadataEntity toMetadataEntity(MetadataDTO metadataDTO) {
        MetadataEntity entity = new MetadataEntity();
        entity.setDescription(metadataDTO.getDescription());

        return entity;
    }
}
