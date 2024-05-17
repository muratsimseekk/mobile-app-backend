package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {

        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }

        //TODO Global exception yaz
        throw new RuntimeException("Ilgili id de category bulunamadi !. ID : " +id);

    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public String  delete(Long id) {
        Category category = findById(id);

        categoryRepository.delete(category);
        return "Category basarili bir sekilde silindi .";
    }
}
