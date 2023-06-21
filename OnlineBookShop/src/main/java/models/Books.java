package models;

public class Books {
    private Integer book_id;
    private String title;
    private int author_id;
    private String genre;
    private int publishers_publisher_id;
    private int bookStock_book_stock_id;

    public Books() {
    }

    public Books(int book_id, String title, int author_id, String genre, int publishers_publisher_id, int bookStock_book_stock_id) {
        this.book_id = book_id;
        this.title = title;
        this.author_id = author_id;
        this.genre = genre;
        this.publishers_publisher_id = publishers_publisher_id;
        this.bookStock_book_stock_id = bookStock_book_stock_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishers_publisher_id() {
        return publishers_publisher_id;
    }

    public void setPublishers_publisher_id(int publishers_publisher_id) {
        this.publishers_publisher_id = publishers_publisher_id;
    }

    public int getBookStock_book_stock_id() {
        return bookStock_book_stock_id;
    }

    public void setBookStock_book_stock_id(int bookStock_book_stock_id) {
        this.bookStock_book_stock_id = bookStock_book_stock_id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author_id=" + author_id +
                ", genre='" + genre + '\'' +
                ", publishers_publisher_id=" + publishers_publisher_id +
                ", bookStock_book_stock_id=" + bookStock_book_stock_id +
                '}';
    }
}
