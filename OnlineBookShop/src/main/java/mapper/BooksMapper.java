package mapper;
import models.Books;

import java.util.List;

public interface BooksMapper {

    Books selectBooksById(int id);
    List<Books> selectAllBooks();
    void insertBooks(Books books);
    void updateBooks(Books books);
    void deleteBooks(int id);
    int getMaxBookId();
}

