import java.time.LocalDate;

class Rental {
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int rentalDuration;
    private Customer customer;
    private Car car;

    public Rental(LocalDate rentalDate, LocalDate returnDate, int rentalDuration, Customer customer, Car car) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalDuration = rentalDuration;
        this.customer = customer;
        this.car = car;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }
}
