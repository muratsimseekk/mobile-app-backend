package com.kitapmobile.Spring.Project.For.Mobile.Book.App.controller;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Translator;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.service.TranslatorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translator")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TranslatorController {

    private TranslatorService translatorService;


    @GetMapping("/")
    public List<Translator> findAll(){
        return translatorService.findAll();
    }

    @GetMapping("/{id}")
    public Translator findById (@PathVariable Long id){
        return translatorService.findById(id);
    }

    @PostMapping("/")
    public Translator save(@RequestBody Translator translator){
        return translatorService.save(translator);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return translatorService.delete(id);
    }

}
