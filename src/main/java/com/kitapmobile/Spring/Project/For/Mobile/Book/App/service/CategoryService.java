package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.CategoryResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

    CategoryResponse save(Category category);

    String delete(Long id);

    Category findByCategoryId(Long id);

}
