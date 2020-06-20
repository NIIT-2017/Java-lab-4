import Employees.*;

public class CreatorForTests {
    public static Project createProject()
    {
        ProjectManager projectManager=createProjectManager();
        return new Project("A",projectManager,100000,10000);
    }
    public static Engineer createEngineer(Class cclass, long salaryForHour) throws Exception
    {
        return (Engineer)cclass.getDeclaredConstructor(String.class,String.class,long.class)
                .newInstance("Peter","Ivanov",salaryForHour);
    }
    public static ProjectManager createProjectManager()
    {
        return new ProjectManager("Ivan","Petrov",1000);
    }
    public static Manager createManager()
    {
        return  new Manager("Oleg","Ivanov");
    }
    public static void addSubordinatesToManager(Manager manager,int number)
    {
        for(int i=0;i<number;i++)
        {
            manager.addSubordinate(Generator.generateEmployee(Engineer.class));
            manager.addSubordinate(Generator.generateEmployee(Programmer.class));
            manager.addSubordinate(Generator.generateEmployee(Tester.class));
        }
    }
}
