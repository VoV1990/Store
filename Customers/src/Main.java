import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Customer ivanov = new Customer("Ivanov", "Ivan", "Ivanovich",
                12345678, 353445);
        Customer sidorov = new Customer("Sidorov", "Ivan", "Andreevich",
                12348765, 451060);
        Customer petrov = new Customer("Petrov", "Petr", "Petrovich",
                12350987, 875906);
        Customer sergeev = new Customer("Sergeev", "Sergey", "Sergeevich",
                12360034, 163587);
        Customer sergeev1 = new Customer("Sergeev", "Andrey", "Sergeevich",
                12360034, 163587);
        Customer[]customers = {ivanov, sidorov, petrov, sergeev, sergeev1};
        CustomersDatabase database = new CustomersDatabase(customers);
        sortInAlphabeticalOrder(database.getCustomers());
        System.out.println(Arrays.toString(database.getCustomers()));

        System.out.println("Please enter credit card number interval (min and max):");
        long min = Long.parseLong(reader.readLine());
        long max = Long.parseLong(reader.readLine());

        getCustomersFromInterval(database, min, max);
    }

    private static void sortInAlphabeticalOrder(Customer[] customers) {
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

    private static void getCustomersFromInterval(CustomersDatabase data, long min, long max) {
        long temp;
        if(min > max) {
            temp = max;
            max = min;
            min = temp;
        }
        for (int i = 0; i < data.getCustomers().length; i++) {
            if(data.getCustomers()[i].getCreditCardNumber() >= min &&
                    data.getCustomers()[i].getCreditCardNumber() <= max)
                System.out.println(data.getCustomers()[i]);
        }
    }
}
