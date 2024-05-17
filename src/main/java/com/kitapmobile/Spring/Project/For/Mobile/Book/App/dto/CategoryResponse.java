package com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;

import java.util.List;
import java.util.Set;

public record CategoryResponse (Long category_id , String category_name , List<Book> books) {
}
