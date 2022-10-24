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
            return Objects.equals(this.getBrand(), current.getBrand())
                    && Objects.equals(this.getModel(), current.getModel())
                    && Objects.equals(this.getAccelerationTime(), current.getAccelerationTime())
                    && Objects.equals(this.getTopSpeed(), current.getTopSpeed())
                    && Objects.equals(driveType, current.driveType)
                    && Objects.equals(gearBox, current.gearBox);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (this.getBrand() == null ? 0 : this.getBrand().hashCode());
        result = 31 * result + (this.getModel() == null ? 0 : this.getModel().hashCode());
        result = (int) (31 * result + this.getAccelerationTime());
        result = 31 * result + this.getTopSpeed();
        result = 31 * result + (driveType == null ? 0 : driveType.hashCode());
        result = 31 * result + (gearBox == null ? 0 : gearBox.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HighSpeedCar{"
                + "brand = '" + this.getBrand() + '\''
                + ", model = '" + this.getModel() + '\''
                + ", accelerationTime = " + this.getAccelerationTime()
                + ", topSpeed = " + this.getTopSpeed()
                + ", driveType = '" + driveType + '\''
                + ", gearBox = '" + gearBox + '\''
                + '}';
    }
}
