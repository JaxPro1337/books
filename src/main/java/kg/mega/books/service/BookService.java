package kg.mega.books.service;

import kg.mega.books.models.dto.BookCreateDto;
import kg.mega.books.models.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book createBooks(BookCreateDto bookCreateDto);

    Book getById(Long id);

    Book updateBook(Book book);

    Boolean deleteBook(Long id);

    List<String> getAuthors();

    List<Book> getByAuthor(String author);
}
