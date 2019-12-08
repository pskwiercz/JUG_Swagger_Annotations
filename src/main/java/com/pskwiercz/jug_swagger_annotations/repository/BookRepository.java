package com.pskwiercz.jug_swagger_annotations.repository;

import com.pskwiercz.jug_swagger_annotations.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
