public class Cashier {

    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;
    private Customer[] customersInQueue;

    // constructor:
    public Cashier() {
        customersInQueue = (Customer[]) new Customer[100000];// necessary?
        queue = new ArrayQueue<Customer>();
        currentCustomer = null;
        totalCustomerWaitTime = 0;
        customersServed = 0;
        totalItemsServed = 0;

    }

    // getters:
    public int getQueueSize() {
        return queue.size();
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;

    }

    public int getTotalCustomersServed() {
        return customersServed;

    }

    public int getTotalItemsServed() {
        return totalItemsServed;

    }

    // methods:
    public void addCustomer(Customer c) {
        this.queue.enqueue(c);
        // if (queue.size() == 1) {
        //     currentCustomer = c;// current customer is at front of queue
        // }

    }

    public void serveCustomers(int currentTime) {

if (currentCustomer == null && !queue.isEmpty()) {
            currentCustomer = queue.dequeue();
            totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
        }

        if (currentCustomer != null) {
            currentCustomer.serve();
            totalItemsServed++;

            if (currentCustomer.getNumberOfItems() == 0) {
                customersServed++;
                currentCustomer = null;
            }
        }








        // if (!queue.isEmpty()) { // queue not empty
        //     if (this.currentCustomer != null && this.currentCustomer.getNumberOfItems() != 0) {// currentCustomer (top or front of queue) done being

        //         for (int i = 0; i < this.currentCustomer.getNumberOfItems(); i++) {// still needs to be served, i keeps
        //                                                                            // track of items
        //             currentCustomer.serve();

        //         }
        //         totalItemsServed += currentCustomer.getNumberOfServedItems();
        //         totalCustomerWaitTime += currentCustomer.getArrivalTime() - currentTime;// correct?
        //         customersServed += 1;
        //         currentCustomer = customersInQueue[queue.size() - 1];
        //         queue.dequeue();

        //     } else {
        //         currentCustomer = customersInQueue[queue.size() - 1];
        //         queue.dequeue();

        //     }

        // }
    }
    // finish toString
@Override
    public String toString() {
        return ("Total Customer Wait Time: " + totalCustomerWaitTime + ", Number Of Customers Served: "
                + customersServed + ", Number Of Items Served: " + totalItemsServed + ".");
    }

}
