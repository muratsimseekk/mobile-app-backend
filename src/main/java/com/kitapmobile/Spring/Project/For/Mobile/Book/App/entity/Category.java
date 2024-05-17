package com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category" , schema = "mobile_app")
public class Category {

    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long categoryId;

    @Column(name = "category_name")
    private String categoryName;



    }
