package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.AuthorResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Author;

import java.util.List;

public interface AuthorService {

    List<AuthorResponse> findAll();

    AuthorResponse findById(Long id);

    AuthorResponse save(Author author);

    Author findByAuthorId(Long id);

    String delete(Long id);


}
