import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
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
        CustomersDatabase database = new CustomersDatabase(ivanov, sidorov, petrov, sergeev, sergeev1);
        System.out.println(Arrays.toString(database.getCustomers()));
        chooseOption(database);
    }

    private static void chooseOption(CustomersDatabase database) throws IOException {
        boolean stop = false;
        int option;
        do{
            System.out.println("Please choose one of the suggested options and enter its number.");
            System.out.println("1. Display the list of customers in alphabetical order.");
            System.out.println("2. Display a list of customers whose credit card number is in the specified interval.");
            option = Integer.parseInt(reader.readLine());
            if(option == 1 || option == 2) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        getListOfCustomers(option, database);
    }

    private static void getListOfCustomers(int option, CustomersDatabase database) throws IOException {
        switch (option) {
            case 1 -> {
                database.sortInAlphabeticalOrder();
                for (int i = 0; i < database.getCustomers().length; i++) {
                        System.out.println(database.getCustomers()[i]);
                }
            }
            case 2 -> {
                System.out.println("Please enter credit card number interval (min and max):");
                long min = Long.parseLong(reader.readLine());
                long max = Long.parseLong(reader.readLine());
                database.getCustomersFromInterval(min, max);
            }
        }
    }
}
