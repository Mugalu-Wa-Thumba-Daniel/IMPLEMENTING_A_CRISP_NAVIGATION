package ImplementingACrispNavigation.model;

public class Student {
    private String id;
    private String name;
    private String department;
    private String address;

    public Student(String id, String name, String department, String address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
