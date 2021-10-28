package staff;

import program.UI;

public class Chef extends Employee {

    private static double bonusRateChef = 3000;
    private static int maxPositionLevelChef = 5;
    private String cuisine;

    public Chef(String name, int positionLevel, double salary, String cuisine) {
        super(name, positionLevel, salary);
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public static double getBonusRateChef() {
        return bonusRateChef;
    }

    public static void setBonusRateChef(double bonusRateChef) {
        Chef.bonusRateChef = bonusRateChef;
    }

    public void receiveBonus() {
        setBonus(getBonus() + bonusRateChef);
    }

    public void promote() {
        if (getPositionLevel() != maxPositionLevelChef) {
            setPositionLevel(getPositionLevel() + 1);
            UI.promotionConfirmationMessage(getName(), getPositionName());
        } else {
            UI.promotionRejectionMessage(getName());
        }
    }

    public String getPositionName() {
        String positionName = "Unspecified";

        if (getPositionLevel() == 1) {
            positionName = "1. Commis Chef";
        } else if (getPositionLevel() == 2) {
            positionName = "2. Chef de Partie";
        } else if (getPositionLevel() == 3) {
            positionName = "3. Sous Chef de Cuisine";
        } else if (getPositionLevel() == 4) {
            positionName = "4. Chef de Cuisine";
        } else if (getPositionLevel() == 5) {
            positionName = "5. Executive Chef";
        }
        return positionName;
    }

    public void setProfessionSpecificInformation() {
        String newCuisine = UI.enterCuisine();
        setCuisine(newCuisine);
    }

    @Override
    public String toString() {
        return "Chef - " +
                super.toString() +
                ", Cuisine: " + cuisine
                ;
    }
}
