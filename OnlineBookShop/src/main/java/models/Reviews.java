package models;

public class Reviews {
    private int review_id;
    private int book_id;
    private int customer_id;
    private Integer rating;
    private String comments;

    public Reviews() {
    }

    public Reviews(int book_id, int customer_id, Integer rating, String comments) {
        this.book_id = book_id;
        this.customer_id = customer_id;
        this.rating = rating;
        this.comments = comments;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "review_id=" + review_id +
                ", book_id=" + book_id +
                ", customer_id=" + customer_id +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}

