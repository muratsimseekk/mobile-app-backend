package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.BookResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookService {

    List<BookResponse> findAll();

    BookResponse findById(Long id);

    BookResponse save(Book book , List<Long> categoryIds , Long authorId);

    Book findByBookId(Long id);

    String delete(Long id);
}
