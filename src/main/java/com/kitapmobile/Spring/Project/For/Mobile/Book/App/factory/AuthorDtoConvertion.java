package com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.AuthorResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorDtoConvertion {


    public static List<AuthorResponse> convertAuthorList(List<Author> authors){
        List<AuthorResponse> authorResponses = new ArrayList<>();
        authors.stream().forEach(author -> authorResponses.add(new AuthorResponse(author.getAuthorId() , author.getAuthorName()
                ,author.getAuthorAbout() , author.getAuthorTitle() , author.getAuthorBirthday() , BookDtoConvertion.convertBookList(author.getBookList()))));

        return authorResponses;
    }

    public static AuthorResponse convertAuthor(Author author){
        return new AuthorResponse(author.getAuthorId() , author.getAuthorName()
                ,author.getAuthorAbout() , author.getAuthorTitle() , author.getAuthorBirthday() , BookDtoConvertion.convertBookList(author.getBookList()));
    }
}
