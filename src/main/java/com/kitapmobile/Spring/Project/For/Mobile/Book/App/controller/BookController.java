package com.kitapmobile.Spring.Project.For.Mobile.Book.App.controller;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.BookResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping("/")
    public List<BookResponse> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    //POST /books?categoryIds=1&categoryIds=2&categoryIds=3 bu tarz bir istek ile birden fazla category id si yollayip book a save edebiliriz.
    @PostMapping("/books")
    public BookResponse save(@RequestBody Book book , @RequestParam List<Long> categoryIds){
        return bookService.save(book , categoryIds);
    }

    @DeleteMapping("/{id}")
    public String delete(Long id){
        return bookService.delete(id);
    }

}
