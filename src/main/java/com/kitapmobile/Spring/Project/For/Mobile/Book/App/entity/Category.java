package com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Category {

    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

}
