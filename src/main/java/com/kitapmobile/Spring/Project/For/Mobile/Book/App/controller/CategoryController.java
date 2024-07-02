package com.kitapmobile.Spring.Project.For.Mobile.Book.App.controller;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.CategoryResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryResponse> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public CategoryResponse save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return categoryService.delete(id);
    }

}
