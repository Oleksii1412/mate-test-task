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
            return Objects.equals(range, current.range)
                    && Objects.equals(batteryCapacity, current.batteryCapacity)
                    && Objects.equals(batteryWarranty, current.batteryWarranty);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + range;
        result = 31 + result + batteryCapacity;
        result = 31 * result + batteryWarranty;
        return result;
    }

    @Override
    public String toString() {
        return "ElectricCar{"
                + "brand = '" + super.getBrand() + '\''
                + ", model = '" + super.getModel() + '\''
                + ", accelerationTime = " + super.getAccelerationTime()
                + ", topSpeed = " + super.getTopSpeed()
                + ", range = " + range
                + ", batteryCapacity = " + batteryCapacity
                + ", batteryWarranty = " + batteryWarranty
                + '}';
    }
}
