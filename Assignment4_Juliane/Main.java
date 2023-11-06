public class Main {
    public static void main(String[] args) {

        // example 1

        Polynomial polynomial = new Polynomial();
        String polynomial1 = "3x^4;2x^2;3x^1;7x^0";
        String polynomial2 = "2x^3;-5x^1;5x^0";
        String result = polynomial.addpoly(polynomial1, polynomial2);
        System.out.println(result);

        // example2
        Polynomial secondPolynomial = new Polynomial();
        String result2 = secondPolynomial.addpoly(result, polynomial2);
        System.out.println(result2);

         // example 3

        Polynomial thirdPolynomial = new Polynomial();
        String polynomial3 = "10x^6;-7x^4;5x^1;21x^0";
        String polynomial4 = "4x^6;3x^4;-5x^1;9x^0";
        String result3 = thirdPolynomial.addpoly(polynomial3, polynomial4);
        System.out.println(result3);

         // example 4

        Polynomial fourthPolynomial = new Polynomial();
        String polynomial5 = "9x^7;2x^6;-10x^4;6x^3;-7x^2;39x^0";
        String polynomial6 = "21x^5;44x^4;-6x^3;8x^1;-13x^0";
        String result4 = fourthPolynomial.addpoly(polynomial5, polynomial6);
        System.out.println(result4);

         // example 5

        Polynomial fifthPolynomial = new Polynomial();
        String result5 = fifthPolynomial.addpoly(result3, result4);
        System.out.println(result5);
    }
}