package com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author , Long> {
}
