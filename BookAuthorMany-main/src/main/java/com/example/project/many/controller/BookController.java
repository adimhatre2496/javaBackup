package com.example.project.many.controller;

import com.example.project.many.model.Book;
import com.example.project.many.model.BookResponse;
import com.example.project.many.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
   private final BookService bookService;

    @PostMapping(value ="/books")
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book){
        BookResponse bookResponse=bookService.addBook(book);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book book=bookService.getById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> allBooks() {
       List<Book>  book=bookService.allBooks();
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}