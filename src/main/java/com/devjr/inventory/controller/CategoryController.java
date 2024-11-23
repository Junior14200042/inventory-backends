package com.devjr.inventory.controller;

import com.devjr.inventory.model.Category;
import com.devjr.inventory.response.CategoryResponseRest;
import com.devjr.inventory.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){

        ResponseEntity<CategoryResponseRest> response = categoryService.search();

        return response;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id){

        ResponseEntity<CategoryResponseRest> response = categoryService.searchById(id);

        return response;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){

        ResponseEntity<CategoryResponseRest> response = categoryService.save(category);

        return response;
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id){

        ResponseEntity<CategoryResponseRest> response = categoryService.update(category,id);

        return response;
    }
}
