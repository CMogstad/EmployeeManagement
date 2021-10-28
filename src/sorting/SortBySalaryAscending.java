package sorting;

import staff.Employee;

import java.util.Comparator;

public class SortBySalaryAscending implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
