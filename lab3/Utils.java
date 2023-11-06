public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in   an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array identical to 'in' except that all the occurrences of
     *         words
     *         found in 'what' have been replaced by the corresponding word from
     *         'with'.
     */

    public static String[] findAndReplace(String[] in, String[] what, String[] with) {

        String[] out = null; // The new array to be returned
        boolean valid = true; // True if the pre-conditions are satisfied

        // Testing pre-conditions

        if ((in == null || what == null || with == null) || (what.length != with.length)) {// formal parameters cannot
                                                                                           // be null, what and with
                                                                                           // arrays must be of same
                                                                                           // length

            valid = false;
        } else if (valid){
            for (int i = 0; i < in.length; i++) {
                if (in[i] == null) {// none of elements in arrays In can be null
                    valid = false;
                } else {
                    for (int j = 0; j < what.length; j++) {
                        if (what[j] == null || with[j] == null) {// none of elements in arrays what and with can be null
                            valid = false;
                        }
                    }

                }
            }
        } 
        if(valid) {
            out = new String[in.length];
            for (int i = 0; i < in.length; i++) {
                //System.out.println("reached");
                out[i] = in[i];
                //System.out.println("reached");
                for (int j = 0; j < what.length; j++) {
                    if (out[i].equals(what[j])) {
                        out[i] = with[j];

                    }
                }
            }

            // replacing:1. compare values of in to what, and find index where this occurs
            // 2. when true, set the value[index we just found of what] to value[index we
            // just found of with]
            // for loops, returns the unchanged in, with, and new what

        }
        return out;

    }
}
