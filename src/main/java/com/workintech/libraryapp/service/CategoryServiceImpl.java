package com.workintech.libraryapp.service;

import com.workintech.libraryapp.entity.Category;
import com.workintech.libraryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return  categoryOptional.get();
        }
        throw new RuntimeException("Category with given id is not exist: " + id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
