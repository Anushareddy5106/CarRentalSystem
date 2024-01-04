import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Adding customers
        Customer customer1 = new Customer("Anusha", "1234567890");
        Customer customer2 = new Customer("Jonh", "9876543210");
        Customer customer3 = new Customer("Jay", "9876543210");
        rentalSystem.addCustomer(customer1);
        rentalSystem.addCustomer(customer2);
        rentalSystem.addCustomer(customer3);

        rentalSystem.displayCustomers();

        // Adding cars
        Car car1 = new Car("Toyota", "Camry", 2022, "Blue", 25000.0, "ABC-456");
        Car car2 = new Car("Honda", "Accord", 2021, "Red", 23000.0, "ABC-123");
        Car car3 = new Car("Scoda", "Accord", 2021, "White", 29000.0, "ABC-789");
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.displayCars();

        // Renting a car
        LocalDate rentalDate = LocalDate.now();
        LocalDate returnDate = rentalDate.plusDays(7);
        rentalSystem.rentCar(customer1, car1, rentalDate, returnDate, 7);

        // Displaying available cars
        rentalSystem.displayAvailableCars();

        // Displaying rental history by customer
        List<Rental> customer1RentalHistory = rentalSystem.viewRentalHistoryByCustomer(customer1);
        System.out.println("Rental history for " + customer1.getName() + ":");
        for (Rental rental : customer1RentalHistory) {
            System.out.println("Rent-1");
            System.out.println("rentalDate : " + rental.getRentalDate() +
                    ", returnDate : " + rental.getReturnDate() + ", rentalDuration : " +
                    rental.getRentalDuration() +
                    ", customer : " + rental.getCustomer().getName() +
                    ", car : " + rental.getCar().getMake());
        }

        // Displaying rental history by car
        List<Rental> car1RentalHistory = rentalSystem.viewRentalHistoryByCar(car1);
        System.out.println("Rental history for " + car1.getMake() + ":");
        for (Rental rental : car1RentalHistory) {
            System.out.println("Rent-1");
            System.out.println("rentalDate : " + rental.getRentalDate() +
                    ", returnDate : " + rental.getReturnDate() + ", rentalDuration : " +
                    rental.getRentalDuration() +
                    ", customer : " + rental.getCustomer().getName() +
                    ", car : " + rental.getCar().getMake());
        }

        // Returning a car
        rentalSystem.returnCar(customer1RentalHistory.get(0), returnDate);

        rentalSystem.deleteCar(car3);

        rentalSystem.displayCars();

        rentalSystem.deleteCustomer(customer3);

        rentalSystem.displayCustomers();

    }
}
