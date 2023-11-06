import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {

        // empty array (variable for methods)
        double[] notes = new double[10]; // length of array between brackets
        Scanner sc = new Scanner(System.in);

        // Prompt to get grades
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            notes[i] = sc.nextDouble();// takes input elements and converts them to type double

        }
        sc.close();// close the scanner extension

        // Printing out results
        System.out.println("Average grade: " + calculateAverage(notes));
        System.out.println("Median grade: " + calculateMedian(notes));
        System.out.println("Number of students who failed: " + calculateNumberFailed(notes));
        System.out.println("Number of students who passed: " + calculateNumberPassed(notes));

    }

    // Calculates the average
    public static double calculateAverage(double[] notes) {
        double sum = 0;
        for (int i = 0; i < notes.length; i++) {
            sum += notes[i];
        }
        return sum / notes.length;
    }

    // Calculates the median
    public static double calculateMedian(double[] notes) {

        Sort(notes);
        int middle = notes.length / 2;// will be middle index since index starts at 0 but length starts at 1
        double median;
        if (notes.length % 2 == 0) {
            median = (notes[middle - 1] + notes[middle]) / 2;
        } else {
            median = notes[middle];
        }
        return median;

    }

    // Sorts array in ascending order
    public static void Sort(double[] notes) {
        int n = notes.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (notes[j] > notes[j + 1]) {
                    // should swap elements
                    double temp = notes[j];
                    notes[j] = notes[j + 1];
                    notes[j + 1] = temp;

                }
            }

        }

    }

    // Calculates the number of failing students
    public static int calculateNumberFailed(double[] notes) {
        int count = 0;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] < 50.0) {
                count++;
            }
        }
        return count;
    }

    // Calculates the number of passing students
    public static int calculateNumberPassed(double[] notes) {
        int count = 0;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] >= 50.0) {
                count++;
            }
        }
        return count;
    }
}
