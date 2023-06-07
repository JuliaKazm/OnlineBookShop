package models;

public class Departments {
    private int department_id;
    private String department_name;
    private int bookStock_book_stock_id;

    public Departments() {
    }

    public Departments(int department_id, String department_name, int bookStock_book_stock_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.bookStock_book_stock_id = bookStock_book_stock_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getBookStock_book_stock_id() {
        return bookStock_book_stock_id;
    }

    public void setBookStock_book_stock_id(int bookStock_book_stock_id) {
        this.bookStock_book_stock_id = bookStock_book_stock_id;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", bookStock_book_stock_id=" + bookStock_book_stock_id +
                '}';
    }
}
