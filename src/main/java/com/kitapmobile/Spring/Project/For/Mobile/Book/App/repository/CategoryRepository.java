package com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
