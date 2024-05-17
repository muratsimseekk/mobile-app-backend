package com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto;

import java.util.List;
import java.util.Set;

public record BookResponse(Long book_id , String book_name , String estimated_time , Integer page_number , String publication_date
        , String publisher , String ISBN , String country , String language , List<BookCategoryResponse> categories , Long author_id , String author_name) {
}
