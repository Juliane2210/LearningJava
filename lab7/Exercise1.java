import java.io.IOException;

public class Exercise1 {

    public static void throwException(int exceptionNumber) throws Exception {
        if (exceptionNumber == 1) {
            throw new Exception();
        }
        if (exceptionNumber == 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (exceptionNumber == 3) {
            throw new IOException();
        }
        if (exceptionNumber == 4) {
            throw new IllegalArgumentException();
        }
        if (exceptionNumber == 5) {
            throw new NullPointerException();
        }
    }

    /*
     * Returns the name of the exception thrown by the method throwException.
     * Method that handles the exceptions thrown by the throwException method.
     * 
     * @param exceptionNumber
     * 
     * @return The exception name or "NoException" if no exception was caught.
     */
    public static String catchException(int exceptionNumber) {
        try {
            throwException(exceptionNumber);
        } catch (Exception e) {
            if (e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("The exception type is : ArrayIndexOutOfBoundsException, the exceptionNumber is: "
                        + exceptionNumber);

                return "ArrayIndexOutOfBoundsException";
            } else if (e instanceof IOException) {
                System.out.println("The exception type is : IOException, the exceptionNumber is: "
                        + exceptionNumber);

                return "IOException";
            } else if (e instanceof IllegalArgumentException) {
                System.out.println("The exception type is : IllegalArgumentException, the exceptionNumber is: "
                        + exceptionNumber);

                return "IllegalArgumentException";
            } else if (e instanceof NullPointerException) {
                System.out.println("The exception type is : NullPointerException, the exceptionNumber is: "
                        + exceptionNumber);

                return "NullPointerException";
            } else {
                System.out.println("The exception type is : Exception, the exceptionNumber is: "
                        + exceptionNumber);

                return "Exception";
            }

        }
        // YOUR CODE HERE
        return "NoException";
    }

    public static void main(String[] args) {
        int exceptionNumber = (int) (Math.random() * 5) + 1;
        String exceptionName = catchException(exceptionNumber);
        System.out.println("Exception number: " + exceptionNumber);
        System.out.println("Exception name: " + exceptionName);
    }

}