package program;

import staff.*;

import static program.StaffManagement.employees;

public class Statistics {

    public static double calcAverageSalaryAllEmployees() {

        if (employees.size() == 0)
            return 0;

        double totalSalary = 0.0;

        for (Employee e : employees) {
            totalSalary = totalSalary + e.getSalary();
        }

        double averageSalary = Math.round(totalSalary / employees.size());
        return averageSalary;
    }

    public static double calcAverageSalaryWaiter() {
        double totalSalary = 0;
        int numberOfWaiters = 0;

        for (Employee e : employees) {
            if (e instanceof Waiter) {
                totalSalary = totalSalary + e.getSalary();
                numberOfWaiters++;
            }
        }

        if (numberOfWaiters == 0)
            return 0;

        double averageSalary = Math.round(totalSalary / numberOfWaiters);
        return averageSalary;
    }

    public static double calcAverageSalaryChef() {
        double totalSalary = 0;
        int numberOfChefs = 0;

        for (Employee e : employees) {
            if (e instanceof Chef) {
                totalSalary = totalSalary + e.getSalary();
                numberOfChefs++;
            }
        }

        if (numberOfChefs == 0)
            return 0;

        double averageSalary = Math.round(totalSalary / numberOfChefs);
        return averageSalary;
    }

    public static double calcAverageSalaryDeliveryMan() {
        double totalSalary = 0;
        int numberOfDeliveryMen = 0;

        for (Employee e : employees) {
            if (e instanceof DeliveryMan) {
                totalSalary = totalSalary + e.getSalary();
                numberOfDeliveryMen++;
            }
        }

        if (numberOfDeliveryMen == 0)
            return 0;

        double averageSalary = Math.round(totalSalary / numberOfDeliveryMen);
        return averageSalary;
    }

    public static double maxSalaryAllEmployees() {
        double maxSalary = employees.get(0).getSalary();

        for (Employee e : employees) {
            if (e.getSalary() > maxSalary) {
                maxSalary = e.getSalary();
            }
        }

        return maxSalary;
    }

    public static double maxSalaryWaiter() {
        double maxSalaryWaiter = 0;

        for (Employee e : employees) {
            if (e instanceof Waiter) {
                if (maxSalaryWaiter < e.getSalary()) {
                    maxSalaryWaiter = e.getSalary();
                }
            }
        }

        return maxSalaryWaiter;
    }

    public static double maxSalaryChef() {
        double maxSalaryChef = 0;

        for (Employee e : employees) {
            if (e instanceof Chef) {
                if (maxSalaryChef < e.getSalary()) {
                    maxSalaryChef = e.getSalary();
                }
            }
        }

        return maxSalaryChef;
    }

    public static double maxSalaryDeliveryMan() {
        double maxSalaryDeliveryMan = 0;

        for (Employee e : employees) {
            if (e instanceof DeliveryMan) {
                if (maxSalaryDeliveryMan < e.getSalary()) {
                    maxSalaryDeliveryMan = e.getSalary();
                }
            }
        }

        return maxSalaryDeliveryMan;
    }

    public static double minSalaryAllEmployees() {
        double minSalary = employees.get(0).getSalary();

        for (Employee e : employees) {
            if (e.getSalary() < minSalary) {
                minSalary = e.getSalary();
            }
        }

        return minSalary;
    }

    public static double minSalaryWaiter() {
        double minSalaryWaiter = 0;

        for (Employee e : employees) {
            if (e instanceof Waiter) {
                minSalaryWaiter = e.getSalary();
                break;
            }
        }

        for (Employee e : employees) {
            if (e instanceof Waiter) {
                if (minSalaryWaiter > e.getSalary()) {
                    minSalaryWaiter = e.getSalary();
                }
            }
        }

        return minSalaryWaiter;
    }

    public static double minSalaryChef() {
        double minSalaryChef = 0;

        for (Employee e : employees) {
            if (e instanceof DeliveryMan) {
                minSalaryChef = e.getSalary();
                break;
            }
        }

        for (Employee e : employees) {
            if (e instanceof Chef) {
                if (minSalaryChef > e.getSalary()) {
                    minSalaryChef = e.getSalary();
                }
            }
        }

        return minSalaryChef;
    }

    public static double minSalaryDeliveryMan() {
        double minSalaryDeliveryMan = 0;

        for (Employee e : employees) {
            if (e instanceof DeliveryMan) {
                minSalaryDeliveryMan = e.getSalary();
                break;
            }
        }

        for (Employee e : employees) {
            if (e instanceof DeliveryMan) {
                if (minSalaryDeliveryMan > e.getSalary()) {
                    minSalaryDeliveryMan = e.getSalary();
                }
            }
        }

        return minSalaryDeliveryMan;
    }

    public static double bonusPaymentAllEmployees() {
        double totalBonus = 0;
        for (Employee e : employees) {
            totalBonus = totalBonus + e.getBonus();
        }
        return totalBonus;
    }

    public static double bonusPaymentWaiters() {
        double totalBonus = 0;
        for (Employee e : employees) {
            if (e instanceof Waiter)
                totalBonus = totalBonus + e.getBonus();
        }
        return totalBonus;
    }

    public static double bonusPaymentChefs() {
        double totalBonus = 0;
        for (Employee e : employees) {
            if (e instanceof Chef)
                totalBonus = totalBonus + e.getBonus();
        }
        return totalBonus;
    }

    public static double bonusPaymentDeliveryMen() {
        double totalBonus = 0;
        for (Employee e : employees) {
            if (e instanceof DeliveryMan)
                totalBonus = totalBonus + e.getBonus();
        }
        return totalBonus;
    }

}
