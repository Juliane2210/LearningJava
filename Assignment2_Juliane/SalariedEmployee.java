
public class SalariedEmployee extends ProfessionalEmployee {
    // Salaried employees have a fixed number of vacation days.
    // private double vacationDaysPerYear;
    // private double healthInsContributionMultiplier;
    // private double hoursWorkedPerWeek;
     private final double WEEKS_PER_YEAR = 52;

    // Constructors:
    public SalariedEmployee() {
        super();
        // // by default, they have 2 weeks vacation
        // vacationDaysPerYear = 14.00;
        // // by default, the healcontribution multiplier is 1% per week
        // healthInsContributionMultiplier = 0.01;
        // hoursWorkedPerWeek = 0.00;
        }

    // Instanciation constructor
    public SalariedEmployee(String name, String sin, int age, String gender, String address, String phoneNum,
            String department,
            String jobTitle, int yearHired,
            double monthlySalary, double vacationDays,
            double healthInsContributionMultiplier,
            double hoursWorkedPerWeek) {
        super(name, sin, age, gender, address, phoneNum, department, jobTitle, yearHired, monthlySalary, vacationDays,
         healthInsContributionMultiplier,
         hoursWorkedPerWeek);
        
    }

    // Getters:
    public double getAnnualSalary() {
        return this.getMonthlySalary() * 12;
    }
    // public double getVacationDays() {
    //     return this.vacationDaysPerYear;
    // }

    // public double getHealthInsContributionMultiplier() {
    //     return this.healthInsContributionMultiplier;
    // }

    // public double getHoursWorkedPerWeek() {
    //     return this.hoursWorkedPerWeek;
    // }

    // Setters

    // toString
    public String toString() {
        String stringAnnualSalary = String.valueOf(this.getAnnualSalary());
        return (super.toString() + ", Annual Salary: "+ stringAnnualSalary + "$ per year, ");

    }

    // Abstract Methods:
    /////////////////////
    @Override
    public double salaryPerWeek() {
        double salaryPerWeek = this.getAnnualSalary() / WEEKS_PER_YEAR;
        return salaryPerWeek;
    }

    @Override
    public double healthCareContributionPerWeek() {
        double healthContributionsPerWeek = this.salaryPerWeek() * this.getHealthInsContributionMultiplier();
        return healthContributionsPerWeek;
    }

    


}
