public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private double unionDues;

    // Constructors:
    public HourlyEmployee() {
        super();
        hourlyRate = 0.00;
        hoursWorked = 0.00;
        unionDues = 0.00;

    }

    // Parametrized constructor
    public HourlyEmployee(String name, String sin, int age, String gender, String address, String phoneNum,
            String department,
            String jobTitle, int yearHired, double hourlyRate,
            double hoursWorked, double unionDues) {
        super(name, sin, age, gender, address, phoneNum, department,jobTitle, yearHired);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.unionDues = unionDues;

    }

    // Getters:
    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getUnionDues() {

        return unionDues;
    }

    // Setters

    // toString
    public String toString() {
        String stringHourlyRate = String.valueOf(this.hourlyRate);
        String stringHoursWorked = String.valueOf(this.hoursWorked);
        String stringUnionDues = String.valueOf(this.unionDues);
        return (super.toString() + stringHourlyRate + " " + stringHoursWorked + " " + stringUnionDues + " ");

    }

}
