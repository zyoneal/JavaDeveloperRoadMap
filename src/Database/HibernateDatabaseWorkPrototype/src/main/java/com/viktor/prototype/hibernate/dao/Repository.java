package com.viktor.prototype.hibernate.dao;

import com.viktor.prototype.hibernate.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<K extends Serializable, E extends BaseEntity<K>> {

    E save(E entity);

    void delete(K id);

    void update(E entity);

    Optional<E> findById(K id);

    List<E> findAll();

}