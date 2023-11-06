import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    // class variables:
    private int capacity;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    // get count:
    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    // Constructor:
    public Dictionary() {
        count = 0;
        capacity = 10;
        elems = new Pair[capacity];/* Your code here */
    }

    // push
    @Override
    public void put(String key, Integer value) {

        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        // if (this.getCapacity() == this.getCount()) {
        // this.changeCapacity();
        // }

        Pair pair = new Pair(key, value);
        elems[count] = pair;
        count += 1;
        this.changeCapacity();

        /* Your code here */
    }

    // dynamic part
    private void changeCapacity() {
        // create new array with incremented growth
        // copy previous elements

        int growFactor = this.getCount() / capacity;

        int newArraySize = capacity + (growFactor * INCREMENT);
        Pair[] biggerArray = new Pair[newArraySize];
        capacity = newArraySize;
        if (count > 0) {
            for (int i = 0; i < this.getCount(); i++) {
                biggerArray[i] = elems[i];
                // elems[i] = null;
            }
        } else {
            biggerArray[0] = elems[0];
        }
        elems = biggerArray;

        /* Your code here. Use this in put() where necessary. */
    }

    // search
    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        // iterate through array and compare the key stored in the pair to the key given
        for (int i = 0; i < this.getCount(); i++) {
            if (elems[i].getKey().equals(key)) {

                return true;
            }
        }
        return false;
    }

    // getter
    @Override
    public Integer get(String key) {

        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if (!this.contains(key)) {
            throw new NoSuchElementException();
        } else {

            for (int i = this.getCount() - 1; i >= 0; i--) {
                Pair pair = elems[i];
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }

            return null;
        }
    }

    // replace value for searched key
    @Override
    public void replace(String key, Integer value) {

        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }
        if (!this.contains(key)) {
            throw new NoSuchElementException();
        }

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
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if (!this.contains(key)) {
            throw new NoSuchElementException();
        }

        for (int i = this.getCount() - 1; i >= 0; i--) {
            Pair pair = elems[i];
            if (pair.getKey().equals(key)) {
                int temp = pair.getValue();
                // shift everything down
                for (int j = i + 1; j < this.getCount(); j++) {
                    elems[j - 1] = elems[j];
                }
                count -= 1;
                this.changeCapacity();
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
