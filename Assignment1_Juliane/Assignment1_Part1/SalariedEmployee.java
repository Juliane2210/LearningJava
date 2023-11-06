
public class SalariedEmployee extends Employee {
    private double annualSalary;

    // Constructors:
    public SalariedEmployee() {
        super();
        annualSalary = 0;
    }

    // Instanciation constructor
    public SalariedEmployee(String name, String sin, int age, String gender, String address, String phoneNum,
            String department,
            String jobTitle, int yearHired,
            double annualSalary) {
        super(name, sin, age, gender, address, phoneNum, department, jobTitle, yearHired);
        this.annualSalary = annualSalary;
    }

    // Getters:
    public double getAnnualSalary() {
        return annualSalary;
    }

    // Setters

    // toString
    public String toString() {
        String stringAnnualSalary = String.valueOf(this.annualSalary);
        return (super.toString() + stringAnnualSalary + " ");

    }

}
