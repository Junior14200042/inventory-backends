package com.devjr.inventory.service;

import com.devjr.inventory.model.Category;
import com.devjr.inventory.response.CategoryResponse;
import com.devjr.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {

    ResponseEntity<CategoryResponseRest> search();

}
