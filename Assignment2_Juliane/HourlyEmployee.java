public class HourlyEmployee extends NonProfessionalEmployee {
    private double hourlyRate;
    private double hoursWorkedPerWeek;
    private double unionDuesMultiplier;
    // amount of vacation per hour worked.
    private double vacationHourlyMultiplier;

    // amount of health insurance per week
    private double healthInsContributionMultiplier;

    // Constructors:
    public HourlyEmployee() {
        super();
        hourlyRate = 0.00;
        hoursWorkedPerWeek = 0.00;
        // by default, the unionDuesMultiplier is 0.01
        unionDuesMultiplier = 0.01;
        // for every hour worked, emplyee gets .1 hour in vacation time.
        vacationHourlyMultiplier = 0.1;
        healthInsContributionMultiplier = 0.00;
        hoursWorkedPerWeek = 0.00;

    }

    // Parametrized constructor
    public HourlyEmployee(String name, String sin, int age, String gender, String address, String phoneNum,
            String department,
            String jobTitle, int yearHired, double hourlyRate,
            double hoursWorkedPerWeek, double vacationHourlyMultiplier,
            double healthInsContributionMultiplier,
            double unionDuesMultiplier) {
        super(name, sin, age, gender, address, phoneNum, department, jobTitle, yearHired, hourlyRate,
                hoursWorkedPerWeek,
                vacationHourlyMultiplier, healthInsContributionMultiplier);
        this.hourlyRate = hourlyRate;
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;
        this.unionDuesMultiplier = unionDuesMultiplier;
        this.vacationHourlyMultiplier = vacationHourlyMultiplier;
        this.healthInsContributionMultiplier = healthInsContributionMultiplier;

    }

    // Getters:
    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorkedPerWeek() {
        return hoursWorkedPerWeek;
    }

    public double getUnionDuesMultiplier() {

        return this.unionDuesMultiplier;
    }

    public double getVacationHourlyMultiplier() {
        return this.vacationHourlyMultiplier;
    }

    public double getHealthInsContributionMultiplier() {
        return this.healthInsContributionMultiplier;
    }

    // Setters

    // toString
    public String toString() {

        return (super.toString() + ", Union Dues Per Week: " + this.unionDuesPerWeek() + "$");// print
        // salary
        // per
        // week,
        // health
        // care per
        // week,
        // union
        // dues per
        // week,
        // vacation
        // days per
        // week

    }

    // Other

    public double unionDuesPerWeek() {
        return this.unionDuesMultiplier * this.salaryPerWeek();
    }

    // Abstract Methods:
    /////////////////////
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

}
