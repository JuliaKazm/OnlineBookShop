package services;

import dao.BooksDAO;
import models.Books;
import java.util.List;

public class BooksService {
    private BooksDAO booksDAO;

    public BooksService() {
        booksDAO = new BooksDAO();
    }

    public void insertBooks(Books books) {
        booksDAO.create(books);
    }

    public Books selectBooks(int bookId) {
        return booksDAO.findById(bookId).orElse(null);
    }

    public List<Books> selectAllBooks() {
        return booksDAO.findAll();
    }

    public void updateBooks(Books books) {
        booksDAO.update(books);
    }

    public void deleteBooks(int bookId) {
        booksDAO.delete(bookId);
    }
}
