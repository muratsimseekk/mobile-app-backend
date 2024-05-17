package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.CategoryResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.exception.CommonException;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory.CategoryDtoConvertion;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> findAll() {
        return CategoryDtoConvertion.convertCategoryList( categoryRepository.findAll());
    }

    @Override
    public CategoryResponse findById(Long id) {

        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()){
            return CategoryDtoConvertion.convertCategory(optional.get());
        }


        throw new CommonException("Ilgili id de category bulunamadi !. ID : " +id , HttpStatus.NOT_FOUND);

    }

    //Delete method da kullanmak icin return tipi Category olan method .
    @Override
    public Category findByCategoryId(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }

        throw new CommonException("Ilgili id de category bulunamadi !. ID : " +id , HttpStatus.NOT_FOUND);
    }

    @Override
    public CategoryResponse save(Category category) {
         categoryRepository.save(category);
         return CategoryDtoConvertion.convertCategory(category);
    }

    @Override
    public String  delete(Long id) {
        Category category = findByCategoryId(id);

        categoryRepository.delete(category);
        return "Category basarili bir sekilde silindi .";
    }


}
