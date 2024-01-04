import java.util.ArrayList;
import java.util.List;

class Car {
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private boolean available;
    private List<Rental> rentalHistory;

    public Car(String make, String model, int year, String color, double price, String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.available = true;
        this.rentalHistory = new ArrayList<>();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Rental> getRentalHistory() {
        return rentalHistory;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addRental(Rental rental) {
        rentalHistory.add(rental);
    }

}
