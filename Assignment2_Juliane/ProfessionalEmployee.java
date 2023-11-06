public class ProfessionalEmployee extends Employee {

    // Instance variables:
    private double monthlySalary;

    // professional employees have a fixed number of vacation days.
    private double vacationDaysPerYear;
    private double healthInsContributionMultiplier;
    private double hoursWorkedPerWeek;
    private final double WEEKS_PER_YEAR = 52;

    // Constructors:
    public ProfessionalEmployee() {
        super();

        // by default, they have 2 weeks vacation
        vacationDaysPerYear = 14.00;
        // by default, the healcontribution multiplier is 1% per week
        healthInsContributionMultiplier = 0.01;
        hoursWorkedPerWeek = 0.00;
    }

    public ProfessionalEmployee(String name, String sin, int age, String gender, String address, String phoneNum,
            String department, String jobTitle, int yearHired, double monthlySalary, double vacationDays,
            double healthInsContributionMultiplier,
            double hoursWorkedPerWeek) {
        super(name, sin, age, gender, address, phoneNum, department, jobTitle, yearHired);
        this.monthlySalary = monthlySalary;

        this.vacationDaysPerYear = vacationDays;
        this.healthInsContributionMultiplier = healthInsContributionMultiplier;
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;

    }

    // Getters:
    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public double getVacationDays() {
        return this.vacationDaysPerYear;
    }

    public double getHealthInsContributionMultiplier() {
        return this.healthInsContributionMultiplier;
    }

    public double getHoursWorkedPerWeek() {
        return this.hoursWorkedPerWeek;
    }

    // Abstract Methods:
    /////////////////////
    @Override
    public double salaryPerWeek() {
        double salaryPerWeek = this.getMonthlySalary() / 4;
        return salaryPerWeek;
    }

    @Override
    public double healthCareContributionPerWeek() {
        double healthContributionsPerWeek = this.salaryPerWeek() * this.getHealthInsContributionMultiplier();
        return healthContributionsPerWeek;
    }

    @Override
    public double vacationDaysEarnedPerWeek() {
        double vacationDaysPerWeek = vacationDaysPerYear / WEEKS_PER_YEAR;
        return vacationDaysPerWeek;
    }

    

    @Override //the toString of Object
    //using super is an example of using inheritance
    public String toString() {
        String employee = super.toString() + ", "+ monthlySalary + "$ per month, " + hoursWorkedPerWeek
                + " hours worked per week," + " Salary Per Week: " + salaryPerWeek()
                + "$, Health Care Contribution Per Week: " + healthCareContributionPerWeek()
                + "$, Vacation Days Earned Per Week: " + vacationDaysEarnedPerWeek()+" days";
        return employee;
    }

}
