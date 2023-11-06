public class Arithmetic extends AbstractSeries {

    // instance variables:
    private double previousValue;
    private int i;

    // default constructor:
    public Arithmetic() {
        previousValue = 0.0;
        i = 1;
    }

    public double next() {
        double nextValue = previousValue + i;// instead of a for loop
        previousValue = nextValue;
        i++;
        return nextValue;
    }

    // double firstElement = 1.0;
    // int size; // instance variables

    // public double next() {
    // if(this.size==1){
    // return firstElement;
    // }
    // for(int i=2;i<=this.size; i++){
    // double sum = firstElement + i;
    // firstElement = sum;
    // return sum;
    // }

    // }
}
