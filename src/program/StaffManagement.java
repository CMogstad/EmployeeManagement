package program;

import sorting.*;
import staff.*;
import java.util.ArrayList;

public class StaffManagement {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static Employee createEmployee() {

        int profession;
        boolean loopChoice;

        do{
            profession = UI.enterProfession();
            if (profession == 1) {
                UI.positionLevelsWaiter();
                loopChoice = false;
            } else if (profession == 2) {
                UI.positionLevelsChef();
                loopChoice = false;
            } else if (profession == 3) {
                UI.positionLevelsDeliveryMan();
                loopChoice = false;
            } else {
                UI.invalidMenuChoiceMessage();
                loopChoice = true;
            }
        } while(loopChoice);

        int positionLevel = UI.enterPositionLevel();

        String name = UI.enterName();

        double salary = UI.enterSalary();

        if (profession == 1) {
            String languageSkill = UI.enterLanguageSkill();

            Waiter waiter = new Waiter(name, positionLevel, salary, languageSkill);
            return waiter;

        } else if (profession == 2) {
            String cuisine = UI.enterCuisine();

            Chef chef = new Chef(name, positionLevel, salary, cuisine);
            return chef;

        } else {
            boolean hasDriversLicense = UI.enterHasDriversLicense();

            DeliveryMan deliveryMan = new DeliveryMan(name, positionLevel, salary, hasDriversLicense);
            return deliveryMan;
        }
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
        UI.employeeCreatedConfirmation(employee);
    }

    public static void removeEmployee() {
        int id = UI.enterId();
        int index = findIndexById(id);
        if (index != -1) {
            UI.employeeRemovedConfirmation(index);
            employees.remove(index);
        } else {
            UI.invalidEmployeeMessage();
        }

    }

    public static int findIndexById(int id) {
        int index = -1;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void findEmployeeById() {
        int id = UI.enterId();
        int index = findIndexById(id);

        System.out.println();
        if (index != -1) {
            System.out.println(employees.get(index));
        } else {
            UI.invalidEmployeeMessage();
        }

    }

    public static void findEmployeeByProfession() {
        int profession = UI.enterProfession();

        System.out.println();
        for (Employee e : employees) {
            if (profession == 1 && e instanceof Waiter) {
                System.out.println(e);
            } else if (profession == 2 && e instanceof Chef) {
                System.out.println(e);
            } else if (profession == 3 && e instanceof DeliveryMan) {
                System.out.println(e);
            }
        }
    }

    public static void showAllEmployees() {
        UI.loopThroughAndPrintAllEmployees();
    }

    public static void sortByNameAscending() {
        employees.sort(new SortByNameAscending());
        UI.loopThroughAndPrintAllEmployees();
    }

    public static void sortBySalaryAscending() {
        employees.sort(new SortBySalaryAscending());
        UI.loopThroughAndPrintAllEmployees();
    }

    public static void sortBySalaryDescending() {
        employees.sort(new SortBySalaryDescending());
        UI.loopThroughAndPrintAllEmployees();
    }

    public static void sortByBonusAscending() {
        employees.sort(new SortByBonusAscending());
        UI.loopThroughAndPrintAllEmployees();
    }

    public static void sortByBonusDescending() {
        employees.sort(new SortByBonusDescending());
        UI.loopThroughAndPrintAllEmployees();
    }

    public static void updateName(int index) {
        String newName = UI.enterName();
        employees.get(index).setName(newName);
        UI.employeeUpdateConfirmation(index);
    }

    public static void updateSalary(int index) {
        double newSalary = UI.enterSalary();
        employees.get(index).setSalary(newSalary);
        UI.employeeUpdateConfirmation(index);
    }

    public static void giveEmployeeBonus() {
        UI.printBonusRateWaiter();
        UI.printBonusRateChef();
        UI.printBonusRateDeliveryMan();

        UI.askWhoGetsBonus();

        int id = UI.enterId();
        int index = StaffManagement.findIndexById(id);

        if (index != -1){
            employees.get(index).receiveBonus();
            UI.bonusConfirmationMessage(index);
        }else {
            UI.invalidEmployeeMessage();
        }
    }

    public static void promoteEmployee() {
        UI.askWhoGetsPromoted();
        int id = UI.enterId();
        int index = StaffManagement.findIndexById(id);

        if (index != -1){
            employees.get(index).promote();
        } else {
            UI.invalidEmployeeMessage();
        }
    }

    public static void updateProfessionSpecificInformation(int index) {
        employees.get(index).setProfessionSpecificInformation();
        UI.employeeUpdateConfirmation(index);
    }

    public static void updateBonusRate() {
        int profession = UI.enterProfession();

        if (profession == 1) {
            UI.printBonusRateWaiter();
            double newBonusRate = UI.enterNewBonusRate();
            Waiter.setBonusRateWaiter(newBonusRate);
        } else if (profession == 2) {
            UI.printBonusRateChef();
            double newBonusRate = UI.enterNewBonusRate();
            Chef.setBonusRateChef(newBonusRate);
        } else if (profession == 3) {
            UI.printBonusRateDeliveryMan();
            double newBonusRate = UI.enterNewBonusRate();
            DeliveryMan.setBonusRateDeliveryMan(newBonusRate);
        } else {
            UI.printBonusRateEmployee();
            double newBonusRate = UI.enterNewBonusRate();
            Employee.setBonusRateEmployee(newBonusRate);
        }

        UI.newBonusRateConfirmation();

    }

}
