public class NonProfessionalEmployee extends Employee {

    private double hourlyRate;
    private double hoursWorkedPerWeek;

    // amount of vacation per hour worked.
    private double vacationHourlyMultiplier;

    // amount of health insurance per week
    private double healthInsContributionMultiplier;

    // Constructors:
    public NonProfessionalEmployee() {
        super();
        hourlyRate = 0.00;
        // for every hour worked, emplyee gets .1 hour in vacation time.
        vacationHourlyMultiplier = 0.1;
        healthInsContributionMultiplier = 0.00;
        hoursWorkedPerWeek = 0.00;
    }

    public NonProfessionalEmployee(String name, String sin, int age, String gender, String address, String phoneNum,
            String department, String jobTitle, int yearHired, double hourlyRate, double hoursWorkedPerWeek,
            double vacationHourlyMultiplier,
            double healthInsContributionMultiplier) {
        super(name, sin, age, gender, address, phoneNum, department, jobTitle, yearHired);
        this.hourlyRate = hourlyRate;
        this.vacationHourlyMultiplier = vacationHourlyMultiplier;
        this.healthInsContributionMultiplier = healthInsContributionMultiplier;
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;

    }

    // Getters:
    public double getHourlyRate() {
        return this.hourlyRate;
    }

    public double getVacationHourlyMultiplier() {
        return this.vacationHourlyMultiplier;
    }

    public double getHealthInsContributionMultiplier() {
        return this.healthInsContributionMultiplier;
    }

    public double getHoursWorkedPerWeek() {
        return this.hoursWorkedPerWeek;
    }

    // Setters:

    // Other Methods:
    ////////////////////
    @Override
    public double salaryPerWeek() {
        double salaryPerWeek = this.getHourlyRate() * this.getHoursWorkedPerWeek();
        return salaryPerWeek;
    }

    @Override
    public double healthCareContributionPerWeek() {
        double healthCareContributionPerWeek = this.getHealthInsContributionMultiplier() * salaryPerWeek();
        return healthCareContributionPerWeek;
    }

    // Non professional emplyees receive vacation based on the number of
    // hours worked in total for the year.
    @Override
    public double vacationDaysEarnedPerWeek() {
        double vacationDaysEarnedPerWeek = (this.hoursWorkedPerWeek * vacationHourlyMultiplier);
        return vacationDaysEarnedPerWeek;
    }

    // overriding?
    public String toString() {
        String employee = super.toString() + ", "+ hourlyRate + "$ per hour, " + hoursWorkedPerWeek + " hours worked per week,"
                + " Salary Per Week: " + salaryPerWeek()
                + "$, Health Care Contribution Per Week: " + healthCareContributionPerWeek()
                + "$, Vacation Days Earned Per Week: " + vacationDaysEarnedPerWeek()+" days";

        return employee;
    }

}
