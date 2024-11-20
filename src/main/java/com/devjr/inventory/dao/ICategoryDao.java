package com.devjr.inventory.dao;

import com.devjr.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends CrudRepository<Category,Long> {
}
