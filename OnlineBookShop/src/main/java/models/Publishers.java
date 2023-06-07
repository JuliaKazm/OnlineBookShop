package models;

public class Publishers {
    private int publisher_id;
    private String name;
    private String phone_number;

    public Publishers() {
    }

    public Publishers(int publisher_id, String name, String phone_number) {
        this.publisher_id = publisher_id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Publishers{" +
                "publisher_id=" + publisher_id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}

