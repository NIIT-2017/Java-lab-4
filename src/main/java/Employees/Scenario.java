package Employees;

public class Scenario {
    public static void main(String[] args) throws  Exception
    {
        //JsonStreamer.writeObjectToFile(new Company[]{Generator.generateCompany()},"GeneratedCompany.json");
        //Project project=JsonStreamer.readProjectFromFile("GeneratedProjects.json");
        //Company company=JsonStreamer.readCompanyFromFile("GeneratedCompany.json");
        run();
    }
    public static void run() throws Exception
    {
       String str= GUI.loadCompanyFile();
       if(str.equals("\n") ||str.equals(""))
           str="GeneratedCompany.json";
       Company company=JsonStreamer.readCompanyFromFile(str);
       int operation=GUI.enterOperation();
       switch (operation)
       {
           case 1:
                GUI.printSalary(-1,company);
               break;
       }
    }
}
