package com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.BookCategoryResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.BookResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class BookCategoryDtoConvertion {
    public static List<BookCategoryResponse> convertBookList (List<Category> categories){
        List<BookCategoryResponse> responseList = new ArrayList<>();

        categories.stream().forEach(book -> responseList.add(new BookCategoryResponse(book.getCategoryId() , book.getCategoryName())));

        return responseList;
    }

    public static BookCategoryResponse convertBook(Category category){
        return  new BookCategoryResponse(category.getCategoryId() , category.getCategoryName());
    }
}
