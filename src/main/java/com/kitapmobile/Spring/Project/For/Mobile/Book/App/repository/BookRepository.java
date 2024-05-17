package com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {
}
