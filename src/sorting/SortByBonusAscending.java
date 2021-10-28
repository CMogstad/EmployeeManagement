package sorting;

import staff.Employee;
import java.util.Comparator;

public class SortByBonusAscending implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getBonus().compareTo(e2.getBonus());
    }
}
