public class EmployeeFactory {
    public static <T extends Employee> T getEmployee(Employee employee){
        switch (employee.position){
            case DRIVER:
                return (T) new Driver(employee);
            case CLEANER:
                return (T) new Cleaner(employee);
            case PROGRAMMER:
                return (T) new Programmer(employee);
            case TESTER:
                return (T) new Tester(employee);
            case PROJECT_MANAGER:
                return (T) new ProjectManager(employee);
            case TEAMLEADER:
                return (T) new TeamLeader(employee);
            case SENIOR_MANAGER:
                return (T) new SeniorManager(employee);

            default:
                return (T) employee;
        }

    }
}
