package com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.BookResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDtoConvertion {

    public static List<BookResponse> convertBookList (List<Book> books){
        List<BookResponse> bookResponses = new ArrayList<>();

        books.stream().forEach(book -> bookResponses.add(new BookResponse(book.getBookId(), book.getBookName()
                , book.getEstimatedTime(), book.getPageNumber(), book.getPublicationDate(), book.getPublisher(), book.getIsbn()
                , book.getCountry(), book.getLanguage(), CategoryDtoConvertion.convertCategoryList(book.getCategories()))));

        return bookResponses;
    }

    public static BookResponse convertBook(Book book){
        return new BookResponse(book.getBookId(), book.getBookName()
                , book.getEstimatedTime(), book.getPageNumber(), book.getPublicationDate(), book.getPublisher(), book.getIsbn()
                , book.getCountry(), book.getLanguage(), CategoryDtoConvertion.convertCategoryList(book.getCategories()));
    }
}
