package akishev.model;

import java.util.Objects;

public class ElectricCar extends Car {
    private int range;
    private int batteryCapacity;
    private int batteryWarranty;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryWarranty() {
        return batteryWarranty;
    }

    public void setBatteryWarranty(int batteryWarranty) {
        this.batteryWarranty = batteryWarranty;
    }

    @Override
    public boolean equals(Object electricCar) {
        if (electricCar == this) {
            return true;
        }
        if (electricCar == null) {
            return false;
        }
        if (electricCar.getClass().equals(ElectricCar.class)) {
            ElectricCar current = (ElectricCar) electricCar;
            return Objects.equals(this.getBrand(), current.getBrand())
                    && Objects.equals(this.getModel(), current.getModel())
                    && Objects.equals(this.getAccelerationTime(), current.getAccelerationTime())
                    && Objects.equals(this.getTopSpeed(), current.getTopSpeed())
                    && Objects.equals(range, current.range)
                    && Objects.equals(batteryCapacity, current.batteryCapacity)
                    && Objects.equals(batteryWarranty, current.batteryWarranty);
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
        result = 31 * result + range;
        result = 31 + result + batteryCapacity;
        result = 31 * result + batteryWarranty;
        return result;
    }

    @Override
    public String toString() {
        return "ElectricCar{"
                + "brand = '" + this.getBrand() + '\''
                + ", model = '" + this.getModel() + '\''
                + ", accelerationTime = " + this.getAccelerationTime()
                + ", topSpeed = " + this.getTopSpeed()
                + ", range = " + range
                + ", batteryCapacity = " + batteryCapacity
                + ", batteryWarranty = " + batteryWarranty
                + '}';
    }
}
