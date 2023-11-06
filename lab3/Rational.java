public class Rational {

  private int numerator;
  private int denominator;

  // constructors

  public Rational(int numerator) {
    this.numerator = numerator;
    this.denominator = 1;
  }

  public Rational(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    this.reduce();
  }

  // getters

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  // instance methods

  public Rational plus(Rational other) {
    int commonDenominator = this.denominator * other.denominator;
    int sumNumerator = (this.numerator*other.denominator)+(other.numerator*this.denominator);
    return new Rational (sumNumerator , commonDenominator);// Your code here
  }

  public static Rational plus(Rational a, Rational b) {
    int commonDenominator = a.denominator * b.denominator;
    int sumNumerator = (a.numerator*b.denominator)+(b.numerator*a.denominator);
    return new Rational (sumNumerator , commonDenominator);// Your code here
  }

  // Transforms this number into its reduced form

  private void reduce() {
    int gcd = gcd(this.numerator, this.denominator);
    this.numerator = this.numerator / gcd;
    this.denominator = this.denominator / gcd;
    // Your code here
  }

  // Euclid's algorithm for calculating the greatest common divisor
  private int gcd(int a, int b) {
    // Note that the loop below, as-is, will time out on negative inputs.
    // The gcd should always be a positive number.
    // Add code here to pre-process the inputs so this doesn't happen.
    /*if (a > 0 && b > 0) {
      while (a != b)
        if (a > b)
          a = a - b;
        else
          b = b - a;
      return a;
    } 
    }*/
    if (b == 0) {
      return a;
  }
  return gcd(b, a % b);
  }

  public int compareTo(Rational other) {
    int difference = this.numerator * other.denominator - other.numerator * this.denominator;//don't need the common denominator
        if (difference < 0) {
            return -1;
        } else if (difference > 0) {
            return 1;
        } else {
            return 0;
        }
    }// Your code here
  

    public boolean equals(Rational other) {
      //2 cases: identical, reduced identical
      if((this.numerator == other.numerator && this.denominator == other.denominator)||(this==other)){
        return true;
      }
      return false;
    // Your code here
  }

  public String toString() {
    
    if (denominator == 1) {
      return Integer.toString(numerator);// Your code here
    } else {
      return numerator + "/" + denominator;// Your code here
    }
    
  }

 
}