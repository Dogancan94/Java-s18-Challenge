package com.workintech.libraryapp.service;

import com.workintech.libraryapp.entity.Category;

public interface CategoryService {
    Category findById(long id);
    Category save(Category category);
}
