package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.AuthorResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Author;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.exception.CommonException;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory.AuthorDtoConvertion;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;
    @Override
    public List<AuthorResponse> findAll() {
        return AuthorDtoConvertion.convertAuthorList(authorRepository.findAll());
    }

    @Override
    public AuthorResponse findById(Long id) {
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isPresent()){
            return AuthorDtoConvertion.convertAuthor(byId.get());
        }
        throw new CommonException("Ilgili id de Author bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public AuthorResponse save(Author author) {
         authorRepository.save(author);
         return AuthorDtoConvertion.convertAuthor(author);
    }

    @Override
    public Author findByAuthorId(Long id) {
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        throw new CommonException("Ilgili id de Author bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public String delete(Long id) {
        Author author = findByAuthorId(id);
        authorRepository.delete(author);
        return  "Author silme islemi basariyla sonuclandi" ;
    }
}
