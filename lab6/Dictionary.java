public class Dictionary implements Map<String, Integer> {

    // class variables:
    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    // get count:
    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    // Constructor:
    public Dictionary() {
        count = 0;
        elems =  new Pair[INITIAL_CAPACITY];
        //elems = (Pair[]) new Object[INITIAL_CAPACITY];/* Your code here */
    }

    // push
    @Override
    public void put(String key, Integer value) {

        if (this.getCapacity() == this.getCount()) {
            this.increaseCapacity();
        }

        Pair pair = new Pair(key, value);
        elems[count] = pair;
        count += 1;

        /* Your code here */
    }

    // dynamic part
    private void increaseCapacity() {
        // create new array with incremented growth
        // copy previous elements
        int newArraySize = this.getCapacity() + INCREMENT;
        Pair[] biggerArray = new Pair[newArraySize];//(Pair[]) new Object[newArraySize];

        for (int i = 0; i < this.getCount(); i++) {
            biggerArray[i] = elems[i];
            elems[i] = null;
        }
        elems = biggerArray;

        /* Your code here. Use this in put() where necessary. */
    }

    // search
    @Override
    public boolean contains(String key) {
        // iterate through array and compare the key stored in the pair to the key given
        for (int i = 0; i < this.getCount(); i++) {
            if (elems[i].getKey() == key) {

                return true;
            }
        }
        return false;
    }

    // getter
    @Override
    public Integer get(String key) {
        for (int i = this.getCount() - 1; i >=0; i--) {
            Pair pair = elems[i];
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return null;
    }

    // replace value for searched key
    @Override
    public void replace(String key, Integer value) {
        for (int i = this.getCount() - 1; i >= 0; i--) {
            Pair pair = elems[i];
            if (pair.getKey() == key) {
                pair.setValue(value);
            }
        }
    }

    // pop but searched and will have to move elements down
    @Override
    public Integer remove(String key) {
        for (int i = this.getCount() - 1; i >= 0; i--) {
            Pair pair = elems[i];
            if (pair.getKey() == key) {
                int temp = pair.getValue();
                // shift everything down
                for (int j = i + 1; j < this.getCount(); j++) {
                    elems[j - 1] = elems[j];
                }
                count -= 1;
                return temp;
            }
        }
        return null;/* Your code here. */
    }

    @Override
    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count - 1; i >= 0; i--) {
            res += elems[i];
            if (i > 0) {
                res += ", ";
            }
        }
        return res + "]}";
    }

}
