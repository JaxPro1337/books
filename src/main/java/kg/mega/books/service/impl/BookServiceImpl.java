package kg.mega.books.service.impl;

import kg.mega.books.exceptions.NotFountAuthor;
import kg.mega.books.exceptions.NotFountBook;
import kg.mega.books.models.dto.BookCreateDto;
import kg.mega.books.models.entity.Book;
import kg.mega.books.repository.BookRepo;
import kg.mega.books.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book createBooks(BookCreateDto bookCreateDto) {
        Book book = Book.builder()
                .author(bookCreateDto.getAuthor())
                .title(bookCreateDto.getTitle())
                .year(bookCreateDto.getYear())
                .isActive(true)
                .build();
        return bookRepo.save(book);
    }

    @Override
    public Book getById(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isEmpty()){
            log.error(String.format("Book with id: %s not found", id));
            throw new NotFountBook(String.format("Book with id: %s not found", id));
        }else
            return  optionalBook.get();


    }

    @Override
    public Book updateBook(Book book) {
        Book book1 = getById(book.getId());
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setYear(book.getYear());
        return bookRepo.save(book1);
    }

    @Override
    public Boolean deleteBook(Long id) {
        Book book1 = getById(id);
        book1.setIsActive(false);
        return true;
    }

    @Override
    public List<String> getAuthors() {
        List<Book> books = bookRepo.findAll();
        List<String> authors = books.stream()
                .map(x -> x.getAuthor())
                .collect(Collectors.toList());
        return authors;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        List<Book> books = bookRepo.findAll();
        List<Book> bookByAuthor = books.stream()
                .filter(x -> x.getAuthor().equals(author))
                .collect(Collectors.toList());
        if (bookByAuthor.size() == 0){
            log.error(String.format("Book with author: %s not found", author));
            throw new NotFountAuthor(String.format("Book with author: %s not found", author));
        }else
            return bookByAuthor;
    }


}
