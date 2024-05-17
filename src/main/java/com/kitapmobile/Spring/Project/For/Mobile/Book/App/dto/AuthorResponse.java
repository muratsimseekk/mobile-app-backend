package com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto;

import java.util.List;

public record AuthorResponse(Long author_id , String author_name , String author_about
        , String author_title , String author_birthday , List<BookResponse> author_book_list) {
}
