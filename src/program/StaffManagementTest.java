package program;

import org.junit.jupiter.api.BeforeEach;
import staff.Chef;
import staff.Employee;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StaffManagementTest {

    @BeforeEach
    Employee createPerson() {
        Employee employee = new Chef("Test", 2, 10000, "French");
        return employee;
    }

    @BeforeEach
    ArrayList<Employee> createArrayList() {
        ArrayList<Employee> employees = new ArrayList<>();
        return employees;
    }

    @BeforeEach
    void addEmployeeToArrayList(Employee employee, ArrayList<Employee> employees){
        employees.add(employee);
    }

    @org.junit.jupiter.api.Test
    void findIndexById(ArrayList<Employee> employees, Employee employee) {
        int index = employees.indexOf(employee);
        assertEquals(employee.getId(), 1);
    }
}