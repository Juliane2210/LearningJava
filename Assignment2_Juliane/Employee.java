abstract class Employee extends Person {
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

    // methods
    @Override
    public String toString() {
        
        String employee = super.toString() + ", " + department + ", " + jobTitle + ", " + yearHired;
        //+ " "  + " Salary Per Week: " + salaryPerWeek()
                // + " Health Care Contribution Per Week: " + healthCareContributionPerWeek()
                // + " Vacation Days Earned Per Week: " + vacationDaysEarnedPerWeek();
        return employee;

    }

    // Methods to be implementd for each child class.
    public abstract double salaryPerWeek();

    public abstract double healthCareContributionPerWeek();

    public abstract double vacationDaysEarnedPerWeek();
}
