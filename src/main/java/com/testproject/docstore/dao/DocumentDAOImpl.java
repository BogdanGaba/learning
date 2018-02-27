package com.testproject.docstore.dao;

import com.testproject.docstore.entity.DocEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DocumentDAOImpl implements DocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DocEntity> getAll() {
        return null;
    }

    @Override
    public Optional<DocEntity> getById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(DocEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(DocEntity entity) {
    }

    @Override
    public void removeById(String id) {

    }
}
