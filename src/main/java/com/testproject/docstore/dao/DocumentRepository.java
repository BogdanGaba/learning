package com.testproject.docstore.dao;

import com.testproject.docstore.entity.DocEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends CrudRepository<DocEntity,String> {

    List<DocEntity> findAll();

    Optional<DocEntity> findById(String id);

}
