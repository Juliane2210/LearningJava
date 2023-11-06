import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {// had to define <Post> as type for comparable so we could use
                                                         // methods from Comparable on methods from post

  protected int likes;// should be private
  private Date timeStamp;
  private String userName;

  // default constructor:
  public Post() {
    this.likes = 0;
    this.timeStamp = Calendar.getInstance().getTime();
    this.userName = "";
  }

  // constructor:
  public Post(String userName) {
    this();// calling the default constructor
    this.userName = userName;
  }

  // getters:
  public String getUserName() {
    return userName;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  // Implement the methods required by the interface Likeable.
  // This file will not compile unless they are present with the correct name and
  // signature.

  public void like() {
    this.likes += 1;
  }

  public int getLikes() {
    return this.likes;

  }

  public String toString() {
    String str = new String();
    str = getClass().getName() + ": " + this.timeStamp + ", " + this.userName + ", likes = " + this.likes;
    return str;
  }

  public int compareTo(Post other) {
    return this.timeStamp.compareTo(other.timeStamp);
  }

  public boolean isPopular() {
    return (this.getLikes() > 100);

  }
}
