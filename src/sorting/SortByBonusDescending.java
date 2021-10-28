package sorting;

import staff.Employee;

import java.util.Comparator;

public class SortByBonusDescending implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e2.getBonus().compareTo(e1.getBonus());
    }
}
