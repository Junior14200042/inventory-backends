package com.devjr.inventory.service;


import com.devjr.inventory.dao.ICategoryDao;
import com.devjr.inventory.model.Category;
import com.devjr.inventory.response.CategoryResponseRest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryDao categoryDao;

    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> search() {

        CategoryResponseRest response= new CategoryResponseRest();

        try {
            List<Category> categories= (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(categories);
            response.setMedatada("Respuesta ok","00","Respuesta exitosa");

        }catch (Exception e){
            response.setMedatada("Respuesta ok","-1","Error al consultar");
            e.getStackTrace();
            return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        CategoryResponseRest response= new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            Optional<Category> category= categoryDao.findById(id);

            if(category.isPresent()){
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMedatada("Respuesta ok","00","Categoria encontrada");
            }else{
                response.setMedatada("Respuesta ok","-1","Categoria no encontrada");
                return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            response.setMedatada("Respuesta ok","-1","Error al consultar");
            e.getStackTrace();
            return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        CategoryResponseRest response= new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
                Category categorySaved = categoryDao.save(category);
                list.add(categorySaved);
                response.getCategoryResponse().setCategory(list);
                response.setMedatada("respuesta ok","00","categoria guardada con exito");


        }catch (Exception e){
            response.setMedatada("Respuesta no ok","-1","Error al guardar");
            e.getStackTrace();
            return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseRest> update(Category category, Long id) {

        CategoryResponseRest response= new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            Optional<Category> categoryById = categoryDao.findById(id);

            if(categoryById.isPresent()){
                Category categoryActual = categoryById.get();

                categoryActual.setName(category.getName());
                categoryActual.setDescription(category.getDescription());

                list.add(categoryActual);
                response.getCategoryResponse().setCategory(list);
                response.setMedatada("respuesta ok","00","categoria modificada con exito");

                categoryDao.save(categoryActual);
            }else{

                response.setMedatada("Respuesta ok","-1","Categoria no encontrada");
                return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);

            }


        }catch (Exception e){
            response.setMedatada("Respuesta no ok","-1","Error al guardar");
            e.getStackTrace();
            return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);




    }
}
