public class Book {

    private String author;
    private String title;
    private int year;
    // Your variables declaration here

    public Book() {
        this.author = "";
        this.title = "";
        this.year = -1;
    }

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
        // Your code here
    }

    public String getAuthor() {
        return author;// Your code here
    }

    public String getTitle() {
        return title;// Your code here
    }

    public int getYear() {
        return year;// Your code here
    }

    @Override
    public boolean equals(Object other) {

        // other can't be null and must be of type book other != null ||
        if (other instanceof Book) {
            Book bookToCompareTo = (Book) other;// casting other to 'type' Book

            // if both titles are null
            if (this.title == null) {
                boolean resultTitle = (this.title == null) && (bookToCompareTo.title == null);
                boolean resultAuthorYear = (this.author.equals(bookToCompareTo.author)
                        && String.valueOf(this.year).equals(String.valueOf(bookToCompareTo.year)));
                return resultTitle && resultAuthorYear;

            }

            // if both authors are null
            if (this.author == null) {
                boolean resultAuthor = (this.author == null) && (bookToCompareTo.author == null);
                boolean resultTitleYear = (this.title.equals(bookToCompareTo.title)
                        && String.valueOf(this.year).equals(String.valueOf(bookToCompareTo.year)));
                return resultAuthor && resultTitleYear;
            }

            // if no entry is null, return True if same memory allocation is referenced [==]
            // OR references to different memory allocation, but content is the same
            // [equals()]
            if (this.title != null || this.author != null) {// can't have a null int
                return (this == other)
                        || (this.author.equals(bookToCompareTo.author) && this.title.equals(bookToCompareTo.title)
                                && String.valueOf(this.year).equals(String.valueOf(bookToCompareTo.year)));
            }

        }

        return false;

    }

    public String toString() {
        return (author + ":  " + title + " (" + year + ") ");// Your code here
    }
}