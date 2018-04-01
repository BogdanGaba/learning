package com.testproject.docstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "document")
public class DocEntity implements Serializable {

    @Id
    private String id;

    private String storageId;

    private String name;

    private String extension;

    private long size;

    @OneToOne(mappedBy = "docEntity",cascade = CascadeType.ALL)
    private MetadataEntity metadataEntity;

    public DocEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public MetadataEntity getMetadataEntity() {
        return metadataEntity;
    }

    public void setMetadataEntity(MetadataEntity metadataEntity) {
        this.metadataEntity = metadataEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocEntity docEntity = (DocEntity) o;
        return size == docEntity.size &&
                Objects.equals(id, docEntity.id) &&
                Objects.equals(storageId, docEntity.storageId) &&
                Objects.equals(name, docEntity.name) &&
                Objects.equals(extension, docEntity.extension) &&
                Objects.equals(metadataEntity, docEntity.metadataEntity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, storageId, name, extension, size, metadataEntity);
    }
}
