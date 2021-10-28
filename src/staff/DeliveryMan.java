package staff;

import program.UI;

public class DeliveryMan extends Employee {

    private static double bonusRateDeliveryMan = 1000;
    private boolean hasDriversLicense;

    public DeliveryMan(String name, int positionLevel, double salary, boolean hasDriversLicense) {
        super(name, positionLevel, salary);
        this.hasDriversLicense = hasDriversLicense;
    }

    public boolean isHasDriversLicense() {
        return hasDriversLicense;
    }

    public void setHasDriversLicense(boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    public static double getBonusRateDeliveryMan() {
        return bonusRateDeliveryMan;
    }

    public static void setBonusRateDeliveryMan(double bonusRateDeliveryMan) {
        DeliveryMan.bonusRateDeliveryMan = bonusRateDeliveryMan;
    }

    public void receiveBonus() {
        setBonus(getBonus() + bonusRateDeliveryMan);
    }

    public String getPositionName() {
        String positionName = "Unspecified";

        if (getPositionLevel() == 1) {
            positionName = "1. Junior Delivery Man";
        } else if (getPositionLevel() == 2) {
            positionName = "2. Mid-level Delivery Man";
        } else if (getPositionLevel() == 3) {
            positionName = "3. Senior Delivery Man";
        }
        return positionName;
    }

    public void setProfessionSpecificInformation() {
        boolean licenseUpdate = UI.enterHasDriversLicense();
        setHasDriversLicense(licenseUpdate);
    }

    @Override
    public String toString() {
        return "Delivery Man - " +
                super.toString() +
                ", Drivers license: " + hasDriversLicense
                ;
    }
}
