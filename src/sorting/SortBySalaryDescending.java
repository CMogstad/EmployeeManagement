package sorting;

import staff.Employee;

import java.util.Comparator;

public class SortBySalaryDescending implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e2.getSalary().compareTo(e1.getSalary());
    }
}
