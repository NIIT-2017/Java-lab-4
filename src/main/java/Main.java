public class Main {
    public static void main(String[] args) {
        DeveloperPersonal persons = new DeveloperPersonal();
        persons.ProjectParse("projects.json");
        persons.PersonsParse("employees.json");
        persons.PaymentAll(100);
        persons.ShowResult();
    }
}
