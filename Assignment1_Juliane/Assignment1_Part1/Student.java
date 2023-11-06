public class Student extends Person {
    private double gpa;
    private String major;
    private int gradYear;

    // Constructors:

    public Student() {
        super();
        gpa = 0.00;
        major = "";
        gradYear = 0;

    }

    // Parametrized constructor
    public Student(String name, String sin, int age, String gender, String address, String phoneNum, double gpa,
            String major, int gradYear) {
        super(name, sin, age, gender, address, phoneNum);
        this.gpa = gpa;
        this.major = major;
        this.gradYear = gradYear;

    }

    // Getters:
    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public int getGradYear() {
        return gradYear;
    }

    // Setters?

    // toString
    public String toString() {
        String stringGpa = String.valueOf(this.gpa);
        String stringGradYear = String.valueOf(this.gradYear);
        return (super.toString() + stringGpa + " " + major + " " + stringGradYear + " ");

    }

}
