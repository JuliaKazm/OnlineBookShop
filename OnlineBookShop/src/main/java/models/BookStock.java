package models;

public class BookStock {
    private int book_stock_id;
    private String address;
    private String phone_number;
    private int department_id;

    public BookStock() {
    }

    public BookStock(int book_stock_id, String address, String phone_number, int department_id) {
        this.book_stock_id = book_stock_id;
        this.address = address;
        this.phone_number = phone_number;
        this.department_id = department_id;
    }

    public int getBook_stock_id() {
        return book_stock_id;
    }

    public void setBook_stock_id(int book_stock_id) {
        this.book_stock_id = book_stock_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "BookStock{" +
                "book_stock_id=" + book_stock_id +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
