package main.java.com.example;

public class Car {
    private String brand;
    private String model;
    private int speed;

    // oletus
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }

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

    public int getSpeed() {
        return speed;
    }

    public void tila() {
        System.out.println("\nAuto: " + brand + " " + model + ", Nopeus: " + speed + " km/h");
    }

    public void accelerate(int amount) {
        this.speed += amount;
    }

    public void decelerate(int amount) {
        if (amount >= speed) {
            this.speed = 0;
        } else {
            this.speed -= amount;
        }
    }
}
