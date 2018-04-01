package com.testproject.docstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "metadata")
public class MetadataEntity implements Serializable {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "document_id")
    private DocEntity docEntity;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocEntity getDocEntity() {
        return docEntity;
    }

    public void setDocEntity(DocEntity docEntity) {
        this.docEntity = docEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataEntity entity = (MetadataEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(docEntity, entity.docEntity) &&
                Objects.equals(description, entity.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, docEntity, description);
    }
}
