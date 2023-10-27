package com.workintech.libraryapp.controller;

import com.workintech.libraryapp.dto.CategoryResponse;
import com.workintech.libraryapp.entity.Category;
import com.workintech.libraryapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public CategoryResponse save(@RequestBody Category category){
        Category savedCategory = categoryService.save(category);
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable long id){
        Category foundCategory = categoryService.findById(id);
        return new CategoryResponse(foundCategory.getId(), foundCategory.getName());
    }
}
