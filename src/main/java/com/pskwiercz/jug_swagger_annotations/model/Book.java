package com.pskwiercz.jug_swagger_annotations.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        private String author;

        private String title;

        private int pages;

        private boolean discount;

    public Book(String author, String title, int pages, boolean discount) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.discount = discount;
    }
}
