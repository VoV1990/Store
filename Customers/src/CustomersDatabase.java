import java.util.Arrays;
import java.util.Comparator;

public class CustomersDatabase {
    private static Customer[] customers;

    public CustomersDatabase() {
    }

    public CustomersDatabase(Customer... customer) {
        cloneArray(customer);
    }

    private static void cloneArray(Customer[] customer) {
        Customer[]tempBase = new Customer[0];
        if(customers != null) {
            tempBase = customers;
            customers = new Customer[tempBase.length + customer.length];
        } else customers = new Customer[customer.length];
        int index = 0;
        int index2 = 0;
        for (; index < tempBase.length; index++) {
            customers[index] = tempBase[index];
        }
        for (; index2 < customer.length; index2++) {
            customers[index] = customer[index2];
            index++;
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void sortInAlphabeticalOrder() {
        Arrays.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if(o1.getLastName().compareTo(o2.getLastName()) != 0)
                    return o1.getLastName().compareTo(o2.getLastName());
                else if(o1.getFirstName().compareTo(o2.getFirstName()) != 0)
                    return o1.getFirstName().compareTo(o2.getFirstName());
                else
                    return o1.getMiddleName().compareTo(o2.getMiddleName());
            }
        });
    }

    public void getCustomersFromInterval(long min, long max) {
        long temp;
        if(min > max) {
            temp = max;
            max = min;
            min = temp;
        }
        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() >= min &&
                    customer.getCreditCardNumber() <= max)
                System.out.println(customer);
        }
    }
}
