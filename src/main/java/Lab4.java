import Staff.DeveloperCompany;
public class Lab4 {
    public static void main(String[] args) {
        DeveloperCompany geeks = new DeveloperCompany("Geeks", 180);
        geeks.companyCreation("/stuff.json");
        geeks.addProjects("/projects.json");
        geeks.assignPerformers();
        geeks.prepareForPayment();
        geeks.accrualOfSalary();
        geeks.printAll();
        geeks.saveStuff("stuff.json");
    }
}
