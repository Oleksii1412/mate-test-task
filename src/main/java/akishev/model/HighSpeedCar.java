package akishev.model;

import java.util.Objects;

public class HighSpeedCar extends Car {
    private String driveType;
    private String gearBox;

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    @Override
    public boolean equals(Object highSpeedCar) {
        if (highSpeedCar == this) {
            return true;
        }
        if (highSpeedCar == null) {
            return false;
        }
        if (highSpeedCar.getClass().equals(HighSpeedCar.class)) {
            HighSpeedCar current = (HighSpeedCar) highSpeedCar;
            return Objects.equals(driveType, current.driveType)
                    && Objects.equals(gearBox, current.gearBox);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (driveType == null ? 0 : driveType.hashCode());
        result = 31 * result + (gearBox == null ? 0 : gearBox.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HighSpeedCar{"
                + "brand = '" + super.getBrand() + '\''
                + ", model = '" + super.getModel() + '\''
                + ", accelerationTime = " + super.getAccelerationTime()
                + ", topSpeed = " + super.getTopSpeed()
                + ", driveType = '" + driveType + '\''
                + ", gearBox = '" + gearBox + '\''
                + '}';
    }
}
