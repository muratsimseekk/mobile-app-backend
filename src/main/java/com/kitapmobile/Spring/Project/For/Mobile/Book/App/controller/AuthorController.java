package com.kitapmobile.Spring.Project.For.Mobile.Book.App.controller;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.AuthorResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Author;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @GetMapping("/")
    public List<AuthorResponse> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorResponse findById(@PathVariable Long id){
        return  authorService.findById(id);
    }

    @PostMapping("/")
    public AuthorResponse save(@RequestBody Author author){
        return authorService.save(author);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return authorService.delete(id);
    }
}
