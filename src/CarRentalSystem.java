import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CarRentalSystem {

    private Map<String, Customer> customers;
    private Map<String, Car> cars;
    private List<Rental> rentalHistory;

    public CarRentalSystem() {
        this.customers = new HashMap<>();
        this.cars = new HashMap<>();
        this.rentalHistory = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer.getName());
    }

    public void addCar(Car car) {
        cars.put(car.getRegistrationNumber(), car);
    }

    public void deleteCar(Car car) {
        cars.remove(car.getRegistrationNumber());
    }

    public void rentCar(Customer customer, Car car, LocalDate rentalDate, LocalDate returnDate, int rentalDuration) {
        if (car.isAvailable()) {
            Rental rental = new Rental(rentalDate, returnDate, rentalDuration, customer, car);
            car.setAvailable(false);
            customer.addRental(rental);
            car.addRental(rental);
            rentalHistory.add(rental);
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Rental rental, LocalDate returnDate) {
        if (!rental.getCar().isAvailable()) {
            rental.getCar().setAvailable(true);
            rentalHistory.add(rental);
            System.out.println("Car returned successfully.  ");
        } else {
            System.out.println("Invalid operation. Car was not rented or is already returned.");
        }
    }

    public List<Rental> viewRentalHistoryByCustomer(Customer customer) {
        List<Rental> customerRentalHistory = new ArrayList<>();
        for (Rental rental : rentalHistory) {
            if (rental.getCustomer().equals(customer)) {
                customerRentalHistory.add(rental);
            }
        }
        return customerRentalHistory;
    }

    public List<Rental> viewRentalHistoryByCar(Car car) {
        List<Rental> carRentalHistory = new ArrayList<>();
        for (Rental rental : rentalHistory) {
            if (rental.getCar().equals(car)) {
                carRentalHistory.add(rental);
            }
        }
        return carRentalHistory;
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Entry<String, Car> entry : cars.entrySet()) {
            Car car = entry.getValue();
            if (car.isAvailable()) {
                System.out.println(car.getMake());
            }
        }
    }

    public void displayCustomers() {
        System.out.println("Customers:");
        for (Entry<String, Customer> entry : customers.entrySet()) {
            Customer customer = entry.getValue();
            System.out.println(customer.getName());
        }
    }

    public void displayCars() {
        System.out.println("Cars:");
        for (Entry<String, Car> entry : cars.entrySet()) {
            Car car = entry.getValue();
            System.out.println(car.getMake());
        }
    }
}