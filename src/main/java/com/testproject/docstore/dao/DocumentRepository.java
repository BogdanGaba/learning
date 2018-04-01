package com.testproject.docstore.dao;

import com.testproject.docstore.entity.DocEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends CrudRepository<DocEntity,String> {

    List<DocEntity> getAll();

    Optional<DocEntity> getById(String id);

//    void update(DocEntity entity);

    void removeById(String id);
}
