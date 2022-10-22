package akishev.model;

public abstract class Car {
    private String brand;
    private String model;
    private double accelerationTime;
    private int topSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public enum CarType {
        HIGH_SPEED("high-speed"),
        ELECTRIC("electric"),
        PICKUP("pickup");

        private final String type;
        CarType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
