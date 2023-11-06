import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
        return library.get(i);
    }

    public int getSize() {
        return library.size();
    }

    public void addBook(Book b) {
        library.add(b);
    }

    public void sort() {
        java.util.Comparator<Book> comparator = new BookComparator();
        this.library.sort(comparator);
        /*
         * for (int i = 0; i < library.size(); i++) {
         * this.sort(compare(this.getBook(i), this.getBook(i + 1)));
         * }
         * 
         * /*
         * for (int i = 0; i < library.size(); i++) {
         * Comparator<Book> comparator = new BookComparator();
         * comparator.compare(this.getBook(i), this.getBook(i + 1));
         * }
         */ // Your code here, sorts books using comparator
    }

    public void printLibrary() {
        for (int i = 0; i < library.size(); i++) {
            System.out.println(this.getBook(i));// Your code here
        }
    }
}
