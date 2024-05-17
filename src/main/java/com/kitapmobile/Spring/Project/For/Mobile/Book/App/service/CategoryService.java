package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    String delete(Long id);

}
