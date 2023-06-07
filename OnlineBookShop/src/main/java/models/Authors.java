package models;

public class Authors {
    private int author_id;
    private String last_name;

    public Authors() {
    }

    public Authors(int author_id, String last_name) {
        this.author_id = author_id;
        this.last_name = last_name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + author_id +
                ", lastName='" + last_name + '\'' +
                '}';
    }
}
