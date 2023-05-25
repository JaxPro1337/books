package kg.mega.books.controllers;

import kg.mega.books.models.dto.BookCreateDto;
import kg.mega.books.models.entity.Book;
import kg.mega.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/books/")
public class BookController {
    private final BookService bookService;

    @GetMapping("get_all")
    public ResponseEntity<?> getAllBooks (){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("create")
    public ResponseEntity<?> createBook (@RequestBody BookCreateDto bookCreateDto){
        return ResponseEntity.ok(bookService.createBooks(bookCreateDto));
    }

    @GetMapping("get_by_id")
    public ResponseEntity<?> getById (@RequestParam Long id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PutMapping("update_book")
    public ResponseEntity<?> updateBook (@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("delete_book")
    public ResponseEntity<?> deleteBook (@RequestParam Long id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @GetMapping ("get_all_authors")
    public ResponseEntity<?> getAuthors(){
        return ResponseEntity.ok(bookService.getAuthors());
    }

    @GetMapping("get_by_author")
    public ResponseEntity<?> getByAuthors (String author){
        return ResponseEntity.ok(bookService.getByAuthor(author));
    }

}
