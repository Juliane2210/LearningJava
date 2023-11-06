public class Test {
    public static void main(String[] args) {
        // Creating instances of Professional and Nonprofessional employees
        ProfessionalEmployee professional = new ProfessionalEmployee("Johnny Depp", "Teacher", 30, 4063.00, 21.00, 0.05, 50 );
        NonProfessionalEmployee nonprofessional = new NonProfessionalEmployee("Anjelina Jolie", "Assistant", 26, 32.00, 0.02, 0.015, 56 );
        
        // Calculating weekly salary, health care contribution, and vacation days earned for each employee
        double professionalSalary = professional.salaryPerWeek();
        double professionalHealthCare = professional.healthCareContributionPerWeek();
        double professionalVacationDays = professional.vacationDaysEarnedPerWeek();
        
        double nonprofessionalSalary = nonprofessional.salaryPerWeek();
        double nonprofessionalHealthCare = nonprofessional.healthCareContributionPerWeek();
        double nonprofessionalVacationDays = nonprofessional.vacationDaysEarnedPerWeek();
        
        // Displaying the information for each employee
        System.out.println(professional.toString());
        System.out.println(nonprofessional.toString());
       
}



}


