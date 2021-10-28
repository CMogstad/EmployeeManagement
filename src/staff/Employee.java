package staff;

import program.UI;

public abstract class Employee {

    private static int employeeCounter = 1;
    private static double bonusRateEmployee = 1000;
    private static int maxPositionLevel = 3;
    private int id;
    private String name;
    private int positionLevel;
    private Double salary;
    private Double bonus;

    public Employee(String name, int positionLevel, Double salary) {
        id = employeeCounter++;
        this.name = name;
        this.positionLevel = positionLevel;
        this.salary = salary;
        bonus = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(int positionLevel) {
        this.positionLevel = positionLevel;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public static double getBonusRateEmployee() {
        return bonusRateEmployee;
    }

    public static void setBonusRateEmployee(double bonusRateEmployee) {
        Employee.bonusRateEmployee = bonusRateEmployee;
    }

    public static int getMaxPositionLevel() {
        return maxPositionLevel;
    }

    public static void setMaxPositionLevel(int maxPositionLevel) {
        Employee.maxPositionLevel = maxPositionLevel;
    }

    public void receiveBonus() {
        bonus = bonus + bonusRateEmployee;
    }

    public void promote() {
        if (getPositionLevel() != getMaxPositionLevel()) {
            setPositionLevel(getPositionLevel() + 1);
            UI.promotionConfirmationMessage(getName(), getPositionName());
        } else {
            UI.promotionRejectionMessage(getName());
        }
    }

    public String getPositionName() {
        String positionName = "Unspecified";

        if (positionLevel == 1) {
            positionName = "1. Junior";
        } else if (positionLevel == 2) {
            positionName = "2. Mid-level";
        } else if (positionLevel == 3) {
            positionName = "3. Senior";
        }
        return positionName;
    }

    public void setProfessionSpecificInformation() {
        System.out.println("Nothing to update!");
    }


   /* @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Position: " + getPositionName() +
                ", Salary: " + salary + "kr" +
                ", Bonus: " + bonus + "kr";
    }*/


    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Position: " + getPositionName() +
                ", Salary: " + salary + "kr" +
                ", Bonus: " + bonus + "kr";
    }
}
