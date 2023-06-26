package solid;

public class AuthorSolid {
    private int authorId;
    private String lastName;

    public AuthorSolid(int authorId, String lastName) {
        this.authorId = authorId;
        this.lastName = lastName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AuthorSolid{" +
                "authorId=" + authorId +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

