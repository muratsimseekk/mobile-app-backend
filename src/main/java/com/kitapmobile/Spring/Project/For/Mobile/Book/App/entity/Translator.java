package com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "translator" , schema = "mobile_app")
public class Translator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translator_id")
    private Long translatorId;

    @Column(name = "about")
    private String about;

    @Column(name = "country")
    private String country;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "translator")
    private List<Book> books = new ArrayList<>();

}
