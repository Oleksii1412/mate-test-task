package akishev.model;

import java.util.Objects;

public class PickupCar extends Car {
    private double fuelConsumption;

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object pickupCar) {
        if (pickupCar == this) {
            return true;
        }
        if (pickupCar == null) {
            return false;
        }
        if (pickupCar.getClass().equals(PickupCar.class)) {
            PickupCar current = (PickupCar) pickupCar;
            return Objects.equals(fuelConsumption, current.fuelConsumption);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = (int) (31 * result + fuelConsumption);
        return result;
    }

    @Override
    public String toString() {
        return "PickupCar{"
                + "brand = '" + super.getBrand() + '\''
                + ", model = '" + super.getModel() + '\''
                + ", accelerationTime = " + super.getAccelerationTime()
                + ", topSpeed = " + super.getTopSpeed()
                + ", fuelConsumption = " + fuelConsumption
                + '}';
    }
}
