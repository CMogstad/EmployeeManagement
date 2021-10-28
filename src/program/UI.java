package program;

import staff.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static program.StaffManagement.employees;

public class UI {

    static Scanner sc = new Scanner(System.in);

    public static int readInt() {
        int number = 0;

        while (true) {
            try {
                number = sc.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter an integer: ");
            } finally {
                sc.nextLine();
            }
        }
    }

    public static double readDouble() {
        double number = 0.0;
        while(true){
            try {
                number = sc.nextDouble();
                return number;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a double: ");
            } finally {
                sc.nextLine();
            }
        }
    }

    public static String readString() {
        String str = sc.nextLine();
        return str;
    }

    public static void printMainMenu() {
        System.out.println("\n----------- MAIN MENU -----------");
        System.out.println("""
                1. Add employee
                2. Remove employee
                3. Update employee information (opens sub menu)
                4. Promote employee
                5. Give employee bonus
                6. Update bonus rates
                7. Search employee by ID
                8. Search employees by profession
                9. Show all employees
                10. Sorting employees (opens sub menu)
                11. Statistics (opens sub menu)
                0. Quit program""");

        System.out.print("\nEnter menu choice: ");
    }

    public static void printUpdateEmployeeMenu(int index) {
        System.out.println("\n----------- UPDATE EMPLOYEE MENU -----------");
        System.out.println("1. Update name");
        System.out.println("2. Update salary");

        if (employees.get(index) instanceof Waiter)
            System.out.println("3. Waiter: Update language skills");

        if (employees.get(index) instanceof Chef)
            System.out.println("3. Chef: Update cuisine");

        if (employees.get(index) instanceof DeliveryMan)
            System.out.println("3. Delivery Man: Update drivers license");

        System.out.println("0. Back to main menu");

        System.out.print("\nEnter menu choice: ");
    }

    public static void printSortingMenu() {
        System.out.println("\n----------- SORTING MENU ----------- ");
        System.out.println("""
                Sort by:
                1. name
                2. lowest to highest salary
                3. highest to lowest salary
                4. lowest to highest bonus
                5. highest to lowest bonus
                0. Back to main menu
                """);
        System.out.print("Enter menu choice: ");
    }

    public static void printStatisticsMenu() {
        System.out.println("\n----------- STATISTICS MENU ----------- ");
        System.out.println("""
                1. Average salary
                2. Maximum salary
                3. Minimum salary
                4. Given bonuses
                0. Back to main menu
                """);
        System.out.print("Enter menu choice: ");
    }

    public static int enterId() {
        System.out.print("\nEnter ID: ");
        int id = UI.readInt();
        return id;
    }

    public static int enterProfession() {
        System.out.println("\n- PROFESSIONS - ");
        System.out.println("""
                1. Waiter
                2. Chef
                3. Delivery Man""");
        System.out.print("\nEnter employee profession: ");
        int profession = UI.readInt();
        return profession;
    }

    public static String enterName() {
        System.out.print("Enter name: ");
        String name = UI.readString();
        return name;
    }

    public static int enterPositionLevel() {
        System.out.print("\nEnter position level: ");
        int positionLevel = UI.readInt();
        return positionLevel;
    }

    public static void positionLevelsWaiter() {
        System.out.println("""
                \n1. Junior Waiter
                2. Mid-level Waiter
                3. Senior Waiter""");
    }

    public static void positionLevelsChef() {
        System.out.println("""
                \n1. Commis Chef
                2. Chef de Cuisine
                3. Sous Chef de Cuisine
                4. Chef de Partie
                5. Executive Chef
                """);
        System.out.println();
    }

    public static void positionLevelsDeliveryMan() {
        System.out.println("""
                \n1. Junior Delivery Man
                2. Mid-level Delivery Man
                3. Senior Delivery Man""");
        System.out.println();
    }

    public static void positionLevelsEmployee() {
        System.out.println("""
                \n1. Junior
                2. Mid-level
                3. Senior""");
        System.out.println();
    }


    public static double enterSalary() {
        System.out.print("Enter salary: ");
        double salary = UI.readDouble();
        return salary;
    }

    public static String enterLanguageSkill() {
        System.out.print("Enter language skills: ");
        String languageSkill = UI.readString();
        return languageSkill;
    }

    public static String enterCuisine() {
        System.out.print("Enter cuisine speciality: ");
        String cuisine = UI.readString();
        return cuisine;
    }

    public static boolean enterHasDriversLicense() {
        boolean hasDriversLicense = false;
        System.out.print("Does the employee have a drivers license? (y/n) ");
        String yesNo = UI.readString();

        if (yesNo.equalsIgnoreCase("y"))
            hasDriversLicense = true;

        return hasDriversLicense;
    }

    public static void employeeCreatedConfirmation(Employee employee) {
        System.out.println("\nEmployee " + employee.getName() + " has been created!");
    }

    public static void employeeUpdateConfirmation(int index) {
        System.out.println("\nEmployee " + employees.get(index).getName() + " has been updated!");
    }

    public static void employeeRemovedConfirmation(int index) {
        System.out.println("\nEmployee " + employees.get(index).getName() + " has been removed!");
    }

    public static void invalidMenuChoiceMessage() {
        System.out.println("Invalid menu choice!");
    }

    public static void printAverageSalaryStatistics() {
        System.out.println("\n- AVERAGE SALARY - ");
        System.out.println("All employees: " + Statistics.calcAverageSalaryAllEmployees() + "kr");
        System.out.println("Waiters: " + Statistics.calcAverageSalaryWaiter() + "kr");
        System.out.println("Chefs: " + Statistics.calcAverageSalaryChef() + "kr");
        System.out.println("Delivery Men: " + Statistics.calcAverageSalaryDeliveryMan() + "kr");
    }

    public static void printMaxSalaryStatistics() {
        System.out.println("\n- MAXIMUM SALARY - ");
        System.out.println("All employees: " + Statistics.maxSalaryAllEmployees() + "kr");
        System.out.println("Waiters: " + Statistics.maxSalaryWaiter() + "kr");
        System.out.println("Chefs: " + Statistics.maxSalaryChef() + "kr");
        System.out.println("Delivery Men: " + Statistics.maxSalaryDeliveryMan() + "kr");

    }

    public static void printMinSalaryStatistics() {
        System.out.println("\n- MINIMUM SALARY - ");
        System.out.println("All employees: " + Statistics.minSalaryAllEmployees() + "kr");
        System.out.println("Waiters: " + Statistics.minSalaryWaiter() + "kr");
        System.out.println("Chefs: " + Statistics.minSalaryChef() + "kr");
        System.out.println("Delivery Men: " + Statistics.minSalaryDeliveryMan() + "kr");
    }

    public static void printBonusStatistics() {
        System.out.println("\n- BONUSES - ");
        System.out.println("All employees: " + Statistics.bonusPaymentAllEmployees() + "kr");
        System.out.println("Waiters: " + Statistics.bonusPaymentWaiters() + "kr");
        System.out.println("Chefs: " + Statistics.bonusPaymentChefs() + "kr");
        System.out.println("Delivery Men: " + Statistics.bonusPaymentDeliveryMen() + "kr");
    }

    public static void invalidEmployeeMessage() {
        System.out.println("\nInvalid employee! Try again.");
    }

    public static void askWhoGetsBonus() {
        System.out.print("\nWho should receive a bonus?");
    }

    public static void bonusConfirmationMessage(int index) {
        System.out.println("\nHurray! " + employees.get(index).getName() + " has been given a bonus!");
    }

    public static void askWhoGetsPromoted() {
        System.out.print("\nWho should get promoted?");
    }

    public static void promotionConfirmationMessage(String name, String positionName) {
        System.out.println("\nHurray! " + name + " has been promoted to: " + positionName);
    }

    public static void promotionRejectionMessage(String name) {
        System.out.println("\n" + name + " already has the most senior position.");
    }

    public static double enterNewBonusRate() {
        System.out.print("Enter new bonus rate: ");
        double newBonusRate = UI.readDouble();
        return newBonusRate;
    }

    public static void printBonusRateWaiter() {
        System.out.println("\nBonus rate for Waiters: " + Waiter.getBonusRateWaiter() + "kr");
    }

    public static void printBonusRateChef() {
        System.out.println("Bonus rate for Chefs: " + Chef.getBonusRateChef() + "kr");
    }

    public static void printBonusRateDeliveryMan() {
        System.out.println("Bonus rate for Delivery Men: " + DeliveryMan.getBonusRateDeliveryMan() + "kr");
    }

    public static void printBonusRateEmployee() {
        System.out.println("Bonus rate for unspecified employees: " + Employee.getBonusRateEmployee() + "kr");
    }

    public static void newBonusRateConfirmation() {
        System.out.println("\nA new bonus rate has been set!");
    }

    public static void loopThroughAndPrintAllEmployees() {
        System.out.println();

        int lengthColumnString = 26;
        int lengthColumnNumber = 12;
        int numberOfSpaces = 0;

        //Headline
        numberOfSpaces = lengthColumnString - "Profession".length();
        System.out.print("Profession");
        printSpaces(numberOfSpaces);

        numberOfSpaces = lengthColumnNumber - "ID".length();
        System.out.print(" ID");
        printSpaces(numberOfSpaces);

        numberOfSpaces = lengthColumnString - "Name".length();
        System.out.print(" Name");
        printSpaces(numberOfSpaces);

        numberOfSpaces = lengthColumnString - "Position".length();
        System.out.print(" Position");
        printSpaces(numberOfSpaces);

        numberOfSpaces = lengthColumnNumber - "Salary".length();
        System.out.print(" Salary");
        printSpaces(numberOfSpaces);

        numberOfSpaces = lengthColumnNumber - "Bonus".length();
        System.out.print(" Bonus");
        printSpaces(numberOfSpaces);

        System.out.println(" Details");

        for (Employee e : employees) {
            //Class
            numberOfSpaces = lengthColumnString - e.getClass().getSimpleName().length();
            System.out.print(e.getClass().getSimpleName());
            printSpaces(numberOfSpaces);

            //ID
            numberOfSpaces = lengthColumnNumber - String.valueOf(e.getId()).length();
            System.out.print(" " + e.getId());
            printSpaces(numberOfSpaces);

            //Name
            numberOfSpaces = lengthColumnString - e.getName().length();
            System.out.print(" " + e.getName());
            printSpaces(numberOfSpaces);

            //Position
            numberOfSpaces = lengthColumnString - e.getPositionName().length();
            System.out.print(" " + e.getPositionName());
            printSpaces(numberOfSpaces);

            //Salary
            numberOfSpaces = lengthColumnNumber - String.valueOf(e.getSalary()).length() - 2;
            System.out.print(" " + e.getSalary() + "kr");
            printSpaces(numberOfSpaces);

            //Bonus
            numberOfSpaces = lengthColumnNumber - String.valueOf(e.getBonus()).length() - 2;
            System.out.print(" " + e.getBonus() + "kr");
            printSpaces(numberOfSpaces);

            //Class Unique
            if (e instanceof Waiter) {
                System.out.print(" Language: " + ((Waiter) e).getLanguageSkill());
            } else if (e instanceof Chef) {
                System.out.print(" Cuisine: " + ((Chef) e).getCuisine());
            } else if (e instanceof DeliveryMan) {
                System.out.print(" Has Drivers License: " + ((DeliveryMan) e).isHasDriversLicense());
            }

            System.out.println();
        }
    }

    public static void printSpaces(int numberOfSpaces) {
        for (int i = 0; i < numberOfSpaces; i++) {
            System.out.print(" ");
        }
    }

}
