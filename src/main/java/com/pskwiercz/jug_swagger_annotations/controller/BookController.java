package com.pskwiercz.jug_swagger_annotations.controller;

import com.pskwiercz.jug_swagger_annotations.model.Book;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(value = "Book Rest API", description = "Operations on books via Rest API")
public interface BookController {

    @ApiOperation(value = "View a list of available books", produces = "application/json", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/book")
    List<Book> getAllBooks();

    @ApiOperation(value = "Get book by Id", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved book"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 500, message = "Book not found")
    })
    @GetMapping("/book/{id}")
    ResponseEntity<Book> getBookById(
            @ApiParam(value = "Book id from which book object will retrieve", required = true) @PathVariable(value = "id") Long bookId)
            throws EntityNotFoundException;

    @ApiOperation(value = "Add book", produces = "application/json")
    @PostMapping("/book")
    Book createBook(
            @ApiParam(value = "Book object store in database", required = true) @Valid @RequestBody Book book);

    @ApiOperation(value = "Delete book", produces = "application/json", response = Map.class)
    @DeleteMapping("/book/{id}")
    Map<String, Boolean> deleteBook(
            @ApiParam(value = "Book Id from which book will be deleted ", required = true) @PathVariable(value = "id") Long bookId)
            throws EntityNotFoundException;
}
