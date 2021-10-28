package program;

import staff.*;

import static program.StaffManagement.employees;

public class Main {

    public static void main(String[] args) {

        boolean menuLoop = true;

        loadDb();

        while (menuLoop) {
            UI.printMainMenu();
            int mainMenuChoice = UI.readInt();

            switch (mainMenuChoice) {
                case 1:
                    Employee employee = StaffManagement.createEmployee();
                    StaffManagement.addEmployee(employee);
                    break;
                case 2:
                    StaffManagement.removeEmployee();
                    break;
                case 3:
                    updateEmployeeSwitchMenu();
                    break;
                case 4:
                    StaffManagement.promoteEmployee();
                    break;
                case 5:
                    StaffManagement.giveEmployeeBonus();
                    break;
                case 6:
                    StaffManagement.updateBonusRate();
                    break;
                case 7:
                    StaffManagement.findEmployeeById();
                    break;
                case 8:
                    StaffManagement.findEmployeeByProfession();
                    break;
                case 9:
                    StaffManagement.showAllEmployees();
                    break;
                case 10:
                    sortingSwitchMenu();
                    break;
                case 11:
                    statisticsSwitchMenu();
                    break;
                case 0:
                    menuLoop = false;
                    break;
                default:
                    UI.invalidMenuChoiceMessage();
            }

        }
    }

    public static void loadDb() {
        Waiter waiter1 = new Waiter("Allan Andersson", 1, 20000, "English");
        Waiter waiter2 = new Waiter("Beatrice Bäckström", 2, 28000, "English, German");
        Chef chef1 = new Chef("Caroline Cederquist", 5, 55000, "Japanese");
        Chef chef2 = new Chef("Doris Danielsson", 3, 32000, "French");
        DeliveryMan deliveryMan1 = new DeliveryMan("Erik Engberg", 3, 24000, true);
        DeliveryMan deliveryMan2 = new DeliveryMan("Frida Frisk", 1, 15000, false);

        employees.add(waiter1);
        employees.add(waiter2);
        employees.add(chef1);
        employees.add(chef2);
        employees.add(deliveryMan1);
        employees.add(deliveryMan2);

        waiter1.setBonus(2000.0);
        chef1.setBonus(3000.0);
        deliveryMan1.setBonus(1000.0);
        deliveryMan2.setBonus(1000.0);

    }


    public static void updateEmployeeSwitchMenu() {

        int id = UI.enterId();
        int index = StaffManagement.findIndexById(id);

        if (index != -1) {
            UI.printUpdateEmployeeMenu(index);
            int subMenuChoice = UI.readInt();

            switch (subMenuChoice) {
                case 1:
                    StaffManagement.updateName(index);
                    break;
                case 2:
                    StaffManagement.updateSalary(index);
                    break;
                case 3:
                    StaffManagement.updateProfessionSpecificInformation(index);
                    break;
                case 0:
                    break;
                default:
                    UI.invalidMenuChoiceMessage();
                    break;
            }
        } else {
            UI.invalidEmployeeMessage();
        }

    }

    public static void statisticsSwitchMenu() {
        boolean subMenuLoop = true;

        while (subMenuLoop) {
            UI.printStatisticsMenu();
            int menuChoice = UI.readInt();

            switch (menuChoice) {
                case 1:
                    UI.printAverageSalaryStatistics();
                    break;
                case 2:
                    UI.printMaxSalaryStatistics();
                    break;
                case 3:
                    UI.printMinSalaryStatistics();
                    break;
                case 4:
                    UI.printBonusStatistics();
                    break;
                case 0:
                    subMenuLoop = false;
                    break;
                default:
                    UI.invalidMenuChoiceMessage();
            }
        }
    }

    public static void sortingSwitchMenu() {
        boolean subMenuLoop = true;

        while (subMenuLoop) {
            UI.printSortingMenu();
            int menuChoice = UI.readInt();

            switch (menuChoice) {
                case 1:
                    StaffManagement.sortByNameAscending();
                    break;
                case 2:
                    StaffManagement.sortBySalaryAscending();
                    break;
                case 3:
                    StaffManagement.sortBySalaryDescending();
                    break;
                case 4:
                    StaffManagement.sortByBonusAscending();
                    break;
                case 5:
                    StaffManagement.sortByBonusDescending();
                    break;
                case 0:
                    subMenuLoop = false;
                    break;
                default:
                    UI.invalidMenuChoiceMessage();
            }
        }
    }

}
