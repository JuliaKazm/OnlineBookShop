package solid;

import dao.BooksDAO;
import models.Books;
import java.util.List;

public class BookServiceSolid {
    private final BooksDAO booksDAO;

    public BookServiceSolid(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    public void insertBook(Books book) {
        booksDAO.create(book);
    }

    public Books getBook(int bookId) {
        return booksDAO.findById(bookId).orElse(null);
    }

    public List<Books> getAllBooks() {
        return booksDAO.findAll();
    }

    public void updateBook(Books book) {
        booksDAO.update(book);
    }

    public void deleteBook(int bookId) {
        booksDAO.delete(bookId);
    }
}

