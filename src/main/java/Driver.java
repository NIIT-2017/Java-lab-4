public class Driver extends Personal {
    private DriverLicenseCategory category;

    public Driver(int id, String name, int worktime, double base, DriverLicenseCategory category){
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.base = base;
        this.category = category;
    }

    public void calc() {
        double salary = result(worktime, base);
        //D - автобусы
        if (category == DriverLicenseCategory.D){
            salary *= 1.05;
        }
        this.payment = salary;
    }
}
