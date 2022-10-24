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
            return Objects.equals(this.getBrand(), current.getBrand())
                    && Objects.equals(this.getModel(), current.getModel())
                    && Objects.equals(this.getAccelerationTime(), current.getAccelerationTime())
                    && Objects.equals(this.getTopSpeed(), current.getTopSpeed())
                    && Objects.equals(fuelConsumption, current.fuelConsumption);
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
        result = (int) (31 * result + fuelConsumption);
        return result;
    }

    @Override
    public String toString() {
        return "PickupCar{"
                + "brand = '" + this.getBrand() + '\''
                + ", model = '" + this.getModel() + '\''
                + ", accelerationTime = " + this.getAccelerationTime()
                + ", topSpeed = " + this.getTopSpeed()
                + ", fuelConsumption = " + fuelConsumption
                + '}';
    }
}
