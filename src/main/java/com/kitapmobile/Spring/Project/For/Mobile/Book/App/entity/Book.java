package com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book",schema = "mobile_app")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "estimated_time")
    private String estimatedTime;

    @Column(name = "page_number")
    private Integer pageNumber;


    @Column(name = "publication_date")
    private String publicationDate;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "country")
    private String country;

    @Column(name = "language")
    private String language;

    @JsonBackReference
    @ManyToMany(mappedBy = "books" , cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Category> categories = new ArrayList<>();

}
