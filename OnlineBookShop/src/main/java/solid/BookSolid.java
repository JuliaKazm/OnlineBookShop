package solid;

public class BookSolid {
    private Integer bookId;
    private String title;
    private int authorId;
    private String genre;
    private int publisherId;
    private int bookStockId;

    public BookSolid() {
    }

    public BookSolid(Integer bookId, String title, int authorId, String genre, int publisherId, int bookStockId) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.genre = genre;
        this.publisherId = publisherId;
        this.bookStockId = bookStockId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getBookStockId() {
        return bookStockId;
    }

    public void setBookStockId(int bookStockId) {
        this.bookStockId = bookStockId;
    }

    @Override
    public String toString() {
        return "BookSolid{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", genre='" + genre + '\'' +
                ", publisherId=" + publisherId +
                ", bookStockId=" + bookStockId +
                '}';
    }
}
