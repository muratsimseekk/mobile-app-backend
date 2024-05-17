package com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.CategoryResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryDtoConvertion {

    public static List<CategoryResponse> convertCategoryList(List<Category> categoryList){
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        categoryList.stream().forEach(category -> categoryResponses.add(new CategoryResponse(category.getCategoryId()
                ,category.getCategoryName() , category.getBooks())));

        return categoryResponses;
    }

    public static CategoryResponse convertCategory(Category category){
        return  new CategoryResponse(category.getCategoryId(), category.getCategoryName(), category.getBooks());
    }
}
