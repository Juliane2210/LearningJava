abstract class Employee2 {

    private String name;
    private String jobTitle;
    private int age;

    // Constructor:

    public Employee2() {
        name = "";
        jobTitle = "";
        age = 0;
    }

    public Employee2(String name, String jobTitle, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
    }
    // Getters:

    public String getName() {
        return this.name;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        String employee = name + " " + jobTitle + " " + age + " Salary Per Week: " + salaryPerWeek()
                + " Health Care Contribution Per Week: " + healthCareContributionPerWeek()
                + " Vacation Days Earned Per Week: " + vacationDaysEarnedPerWeek();
        return employee;
    }

    // Methods to be implementd for each child class.
    public abstract double salaryPerWeek();

    public abstract double healthCareContributionPerWeek();

    public abstract double vacationDaysEarnedPerWeek();
}