package com.example.libraryntcc;

public class Employee {
    String AdminId,name,phone,email;

    public Employee(String adminId, String name, String phone, String email) {
        AdminId = adminId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Employee() {
    }

    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
