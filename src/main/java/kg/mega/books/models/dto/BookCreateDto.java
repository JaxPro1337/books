package kg.mega.books.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCreateDto {
    String title;
    String author;
    Integer year;

}
