import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

    /********************* Nested Term Class *************************/
    private class Term {
        private int coefficient;
        private int exponent;

        public Term(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }

        @Override
        public String toString() {
            if (coefficient != 0) {

                return coefficient + "x^" + exponent;
            }
            return null;

        }

    }

    /******************* End of Nested Term Class *******************/

    private LinkedList<Term> terms;

    public Polynomial() {
        this.terms = new LinkedList<>();

    }

    public Polynomial(String stringPolynomial) {
        terms = new LinkedList<>();
        parse(stringPolynomial);
    }

    private void parse(String stringPolynomial) {
        // we want to distinguish each term by splitting when we encounter ;
        String[] stringTerms = stringPolynomial.split(";");

        // we need to distinguish thee coefficient and exponent part of the Term
        for (String stringTerm : stringTerms) {
            String[] partsOfTerms = stringTerm.split("x\\^");
            int coefficient = Integer.parseInt(partsOfTerms[0]);
            int exponent = Integer.parseInt(partsOfTerms[1]);
            // creating array of terms
            Term term = new Term(coefficient, exponent);
            terms.add(term);

        }
    }

    public String addpoly(String polynomial1, String polynomial2) {
        Polynomial firstPolynomial = new Polynomial(polynomial1);
        Polynomial secondPolynomial = new Polynomial(polynomial2);
        Polynomial result = new Polynomial();

        ListIterator<Term> firstIterator = firstPolynomial.terms.listIterator();
        ListIterator<Term> secondIterator = secondPolynomial.terms.listIterator();

        // iterating through the terms in the list to compare exponents and add
        // coefficients
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            Term term1 = firstIterator.next();
            Term term2 = secondIterator.next();

            if (term1.exponent > term2.exponent) {
                result.terms.add(term1);
                // iterators will automatical increase one, we go back because we want to
                // compare with current value for the next round
                secondIterator.previous();
            } else if (term1.exponent < term2.exponent) {
                result.terms.add(term2);
                // iterators will automatical increase one, we go back because we want to
                // compare with current value for the next round
                firstIterator.previous();
            } else {// exponents of both terms are equal
                int newCoefficient = term1.coefficient + term2.coefficient;
                //condition in our term toString(), coefficient cannot be null 
                if (newCoefficient != 0) {
                    Term newTerm = new Term(newCoefficient, term1.exponent);
                    // add new term to the list
                    result.terms.add(newTerm);
                }
            }

        }

        // add any terms that didn't have an exponent match

        while (firstIterator.hasNext()) {
            Term term = firstIterator.next();
            result.terms.add(term);
        }

        while (secondIterator.hasNext()) {
            Term term = secondIterator.next();
            result.terms.add(term);
        }
        // convert list to String

        return result.toString();

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // : is a built in iterator syntax gives each term in terms
        for (Term term : terms) {
            // separating each term with ;
            stringBuilder.append(term).append(";");
        }
        if (stringBuilder.length() > 0) {
            // removing the last ;
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

}
