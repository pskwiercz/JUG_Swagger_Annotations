package com.pskwiercz.jug_swagger_annotations;

import com.pskwiercz.jug_swagger_annotations.model.Book;
import com.pskwiercz.jug_swagger_annotations.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DataLoader implements ApplicationRunner {

    private BookRepository bookRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void run(ApplicationArguments args) {
        bookRepository.save(new Book("Sam Newman", "Building Microservices", 300, false));
        bookRepository.save(new Book("Robert Martin", "Clean Code", 400, true));
        bookRepository.save(new Book("Robert Martin", "Clean Architecture", 433, true));

        bookRepository.findAll().forEach(x -> log.info(x.toString()));
    }
}