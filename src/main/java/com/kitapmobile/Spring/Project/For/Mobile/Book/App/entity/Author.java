package com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "author" , schema = "mobile_app")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_about")
    private String authorAbout;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_title" )
    private String authorTitle;

    @Column(name = "author_birthday")
    private String authorBirthday;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();
}
