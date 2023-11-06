public class Geometric extends AbstractSeries {

    private double previousValue;
    private int i;// instance variables

    // default constructor:
    public Geometric() {
        previousValue = 0.0;
        i = 0;
    }

    public double next() {
        double nextValue = previousValue + Math.pow(2, -i);
        previousValue = nextValue;
        i++;
        return nextValue;
        // implement the method

    }
}
