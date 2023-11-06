public class NonProfessionalEmployee extends Employee2 {

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

    public NonProfessionalEmployee(String name, String jobTitle, int age, double hourlyRate, double vacationHourlyMultiplier,
            double healthInsContributionMultiplier,
            double hoursWorkedPerWeek) {
        super(name, jobTitle, age);
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


    /*public String toString() {
        String employee = name + " " + jobTitle + " " + age + " Salary PerWeek: " + salaryPerWeek();
        return employee;
    }*/

}
