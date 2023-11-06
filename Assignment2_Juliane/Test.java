public class Test {
    public static void main(String[] args) {

        // // Calculating weekly salary, health care contribution, and vacation days
        // earned
        // // for each employee
        // double professionalSalary = professional.salaryPerWeek();
        // double professionalHealthCare = professional.healthCareContributionPerWeek();
        // double professionalVacationDays = professional.vacationDaysEarnedPerWeek();

        // double nonprofessionalSalary = nonprofessional.salaryPerWeek();
        // double nonprofessionalHealthCare =
        // nonprofessional.healthCareContributionPerWeek();
        // double nonprofessionalVacationDays =
        // nonprofessional.vacationDaysEarnedPerWeek();

        // // Displaying the information for each employee
        // System.out.println(professional.toString());
        // System.out.println(nonprofessional.toString());

        /////////////////////////////////////////////////////////////////

        int MAX_PEOPLE = 7;
        // defining an array of 5 people
        Person[] people = new Person[MAX_PEOPLE];

        // Creating specific type of people
        Student student1 = new Student("Bertrand", "111222333", 62, "Male", "36 Wrigley Cresc. ",
                "514-692-4405", 9.1,
                "psychology", 2023);

        HourlyEmployee hourly1 = new HourlyEmployee("Julie", "543907260", 36, "Female", "453 Bank St. ",
                "613-633-9076",
                "Human Ressources",
                "Humman Resource Specialist", 2019, 42.00, 95.00, 0.012, 0.017, 0.005);

        Student student2 = new Student("Thomas", "329745662", 20, "Male", "81 Spadia Ave. ", "438-526-6091",
                8.6,
                "chemistry", 2025);

        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Paul", "571330926", 43, "Male",
                "1092 Morgana Way ", "514-692-4405", "IT",
                "Software Engineer", 2011, 7505.15, 30, 0.01, 58);

        Student student3 = new Student("Gemma", "904852936", 19, "Female", "525 Elm St. ", "613-890-0514", 8.9,
                "mathematics", 2026);

        // Creating instances of Professional and Nonprofessional employees
        ProfessionalEmployee professional = new ProfessionalEmployee("Johnny Depp", "635960113", 30, "male",
                "92 Pinto St.", "819-036-7765", "education", "Teacher", 2010, 4063.00, 21.00, 0.05,
                50);
        NonProfessionalEmployee nonprofessional = new NonProfessionalEmployee("Anjelina Jolie", "479376449", 26,
                "female", "387 Weetland Ave.", "783-920-6648", "administrative", "Assistant", 2017, 32.00,
                56, 0.02, 0.015);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Polymorphism, referencing more specific type via its generic base type
        people[0] = student1;
        people[1] = hourly1;
        people[2] = student2;
        people[3] = salariedEmployee1;
        people[4] = student3;
        people[5] = professional;
        people[6] = nonprofessional;

        for (int i = 0; i < MAX_PEOPLE; i++) {
            System.out.println(people[i]);
        }

    }

}
