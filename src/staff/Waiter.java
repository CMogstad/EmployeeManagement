package staff;

import program.UI;

public class Waiter extends Employee {

    private static double bonusRateWaiter = 2000;
    private String languageSkill;

    public Waiter(String name, int positionLevel, double salary, String languageSkill) {
        super(name, positionLevel, salary);
        this.languageSkill = languageSkill;
    }

    public String getLanguageSkill() {
        return languageSkill;
    }

    public void setLanguageSkill(String languageSkill) {
        this.languageSkill = languageSkill;
    }

    public static double getBonusRateWaiter() {
        return bonusRateWaiter;
    }

    public static void setBonusRateWaiter(double bonusRateWaiter) {
        Waiter.bonusRateWaiter = bonusRateWaiter;
    }

    public void receiveBonus() {
        setBonus(getBonus() + bonusRateWaiter);
    }

    public String getPositionName() {
        String positionName = "Unspecified";

        if (getPositionLevel() == 1) {
            positionName = "1. Junior Waiter";
        } else if (getPositionLevel() == 2) {
            positionName = "2. Mid-level Waiter";
        } else if (getPositionLevel() == 3) {
            positionName = "3. Senior Waiter";
        }
        return positionName;
    }

    public void setProfessionSpecificInformation() {
        String newLanguage = UI.enterLanguageSkill();
        setLanguageSkill(newLanguage);
    }

    @Override
    public String toString() {
        return "Waiter - " +
                super.toString() +
                ", Language skills: " + languageSkill
                ;
    }
}
