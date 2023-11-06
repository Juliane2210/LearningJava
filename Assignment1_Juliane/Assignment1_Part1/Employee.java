public class Employee extends Person {
    private String department;
    private String jobTitle;
    private int yearHired;

    // Constructors:

    public Employee() {
        super();
        department = "";
        jobTitle = "";
        yearHired = 0;
    }

    // Parametrized constructor
    public Employee(String name, String sin, int age, String gender, String address, String phoneNum, String department,
            String jobTitle, int yearHired) {
        super(name, sin, age, gender, address, phoneNum);
        this.department = department;
        this.jobTitle = jobTitle;
        this.yearHired = yearHired;

    }

    // Getters:
    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getYearHired() {
        return yearHired;
    }

    // Setters
    public String toString() {
        String stringYearHired = String.valueOf(this.yearHired);
        return (super.toString() + department + " " + jobTitle + " " + stringYearHired + " ");

    }
}
