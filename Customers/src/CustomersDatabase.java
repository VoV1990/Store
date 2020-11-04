public class CustomersDatabase {
    private Customer[] customers;

    public CustomersDatabase() {
    }

    public CustomersDatabase(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }
}
