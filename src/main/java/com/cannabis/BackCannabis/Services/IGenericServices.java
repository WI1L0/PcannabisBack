package com.cannabis.BackCannabis.Services;

import java.io.Serializable;
import java.util.List;

public interface IGenericServices<T, ID extends Serializable> {
    public List<T> findByAll();

    public T save(T entity);

    public T findById(ID id);

    public void delete(ID id);

}
