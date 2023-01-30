package com.example.project.many.service;


import com.example.project.many.entity.BookEntity;
import com.example.project.many.mapper.BookMapper;
import com.example.project.many.model.Book;
import com.example.project.many.model.BookResponse;
import com.example.project.many.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookResponse addBook(Book book) {
        BookEntity bookEntity = bookMapper.modelToEntity(book);
        bookRepository.save(bookEntity);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(bookEntity.getId());
        log.info("book add with id {} ", bookResponse);
        return bookResponse;
    }
    public Book getById(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);
        Book book = new Book();
        if (bookEntityOptional.isPresent()) {
            book = bookMapper.entityToMode(bookEntityOptional.get());
            log.info("book find with id {}", id);
        } else {
            log.info("book with id {} not found", id);
        }
        return book;
    }

    public List<Book> allBooks() {

        return bookMapper.entityToList(bookRepository.findAll());
    }
    public void deleteById(Long id) {

        bookRepository.deleteById(id);

    }
}
