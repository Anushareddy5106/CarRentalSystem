import java.util.List;
import java.util.ArrayList;

class Customer {
    private String name;
    private String contactInformation;
    private List<Rental> rentalHistory;

    public Customer(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public List<Rental> getRentalHistory() {
        return rentalHistory;
    }

    public void addRental(Rental rental) {
        rentalHistory.add(rental);
    }

    public void removeRental(Rental rental) {
        rentalHistory.remove(rental);
    }

}
