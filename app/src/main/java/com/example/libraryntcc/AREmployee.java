package com.example.libraryntcc;

import java.util.ArrayList;

public class AREmployee {
    ArrayList<Employee> AdminResponse;

    public ArrayList<Employee> getAdminResponse() {
        return AdminResponse;
    }

    public void setAdminResponse(ArrayList<Employee> adminResponse) {
        AdminResponse = adminResponse;
    }

    public AREmployee() {
    }

    public AREmployee(ArrayList<Employee> adminResponse) {
        AdminResponse = adminResponse;
    }
}
