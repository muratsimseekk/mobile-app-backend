package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Translator;

import java.util.List;

public interface TranslatorService {
    List<Translator> findAll();
    Translator findById(Long id);
    Translator save(Translator translator);
    String delete(Long id);
}
