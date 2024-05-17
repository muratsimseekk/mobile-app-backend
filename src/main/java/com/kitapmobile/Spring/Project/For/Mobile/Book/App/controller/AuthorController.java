package com.kitapmobile.Spring.Project.For.Mobile.Book.App.controller;

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
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id){
        return  authorService.findById(id);
    }

    @PostMapping("/")
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return authorService.delete(id);
    }
}
