package models;

public class Employees {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String position;
    private int Departments_department_id;
    private String date_of_birth;

    public Employees() {
    }

    public Employees(int employee_id, String first_name, String last_name, String position, int Departments_department_id, String date_of_birth) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.Departments_department_id = Departments_department_id;
        this.date_of_birth = date_of_birth;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartments_department_id() {
        return Departments_department_id;
    }

    public void setDepartments_department_id(int Departments_department_id) {
        this.Departments_department_id = Departments_department_id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", position='" + position + '\'' +
                ", Departments_department_id=" + Departments_department_id +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}

