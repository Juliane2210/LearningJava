import java.util.Random;

public class Customer {
    // class variables:
    private int arrivalTime;
    private int initialNumberOfItems;// items not served total
    private int numberOfItems;// items served
    private static final int MAX_NUM_ITEMS = 25;

    // constructor:
    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        Random generator = new Random();
        this.numberOfItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1;
        this.initialNumberOfItems = 0;

    }

    // getters:
    public int getArrivalTime() {
        return arrivalTime;

    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return initialNumberOfItems;
    }

    // methods:
    public void serve() {
        if (numberOfItems > 0) {
            numberOfItems--;
            initialNumberOfItems++;
        }

    }
}
