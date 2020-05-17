import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Company com = new Company();
        com.createEmployees("StaffList.json");
        com.readProjectsList("Projects.json");
        File file = new File("MonthSalary.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.printf("%-300s%n","_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            writer.printf("%-32s%-30s%-30s%-30s%-30s%-30s%-30s%-10s%n","Name","Position","Rate(rubles)", "Worktime(hours)", "Month salary(rubles)", "Business trips", "Projects", "Numbers of employee");
            writer.printf("%-300s%n","_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.printf("%-300s%n","_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.printf("%-32s%-30s%-30s%-30s%-30s%-30s%-30s%-10s%n","Name","Position","Rate(rubles)", "Worktime(hours)", "Month salary(rubles)", "Business trips", "Projects", "Numbers of employee");
        System.out.printf("%-300s%n","_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        //Calculate month  salary for cleaners
        ArrayList<Cleaner> cleaners = com.getAllCleaners();
        for (int c = 0; c<cleaners.size(); c++) {
            float workedHours = (float) ((Math.random() * (63-21)+21));
            cleaners.get(c).setWorktime(workedHours);
            cleaners.get(c).getRate();
            cleaners.get(c).calculateSalary();
            System.out.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", cleaners.get(c).getFio(), cleaners.get(c).getPosition(), cleaners.get(c).getRate(), cleaners.get(c).getWorktime(), cleaners.get(c).getPayment(), 0, "NO", 0);
            writer.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", cleaners.get(c).getFio(), cleaners.get(c).getPosition(), cleaners.get(c).getRate(), cleaners.get(c).getWorktime(), cleaners.get(c).getPayment(), 0, "NO", 0);
        }
        //Calculate month  salary for drivers
        ArrayList<Driver> drivers = com.getAllDrivers();
        for (int d = 0; d<drivers.size(); d++) {
            float workedHours = (float) ((Math.random() * (84-24)+24));
            drivers.get(d).setWorktime(workedHours);
            drivers.get(d).getRate();
            drivers.get(d).calculateSalary();
            System.out.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", drivers.get(d).getFio(), drivers.get(d).getPosition(), drivers.get(d).getRate(), drivers.get(d).getWorktime(), drivers.get(d).getPayment(), drivers.get(d).getBusinessTrip(), "NO", 0);
            writer.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", drivers.get(d).getFio(), drivers.get(d).getPosition(), drivers.get(d).getRate(), drivers.get(d).getWorktime(), drivers.get(d).getPayment(), drivers.get(d).getBusinessTrip(), "NO", 0);
        }
        //Calculate month  salary for managers
        ArrayList<Manager> managers = com.getAllManegers();
        for (int m = 0; m<managers.size(); m++) {
            String project = managers.get(m).getProject();
            float budget = com.getBudget(project);
            float proportionOfParticipationInProject = managers.get(m).getProportionOfParticipationInProject(budget);
            managers.get(m).calculateSalaryForTheProject(proportionOfParticipationInProject,  managers.get(m).getprojectTermInMonths());
            System.out.printf("%-32s%-30s%-30s%-30s%-30.2f%-30d%-30s%-10d%n", managers.get(m).getFio() , managers.get(m).getPosition(), "NO", "NO", managers.get(m).getPayment(), 0, managers.get(m).getProject(), 0);
            writer.printf("%-32s%-30s%-30s%-30s%-30.2f%-30d%-30s%-10d%n", managers.get(m).getFio() , managers.get(m).getPosition(), "NO", "NO", managers.get(m).getPayment(), 0, managers.get(m).getProject(), 0);
        }
        //Calculate month  salary for project managers
        ArrayList<ProjectManager> projectManagers = com.getAllProjectManagers();
        for (int pm = 0; pm<projectManagers.size(); pm++){
            String project = projectManagers.get(pm).getProject();
            projectManagers.get(pm).getRate();
            projectManagers.get(pm).calculateSalaryForHeading(com.getNumberOfEmployeesInProject(project));
            System.out.printf("%-32s%-30s%-30s%-30s%-30.2f%-30d%-30s%-10d%n", projectManagers.get(pm).getFio() , projectManagers.get(pm).getPosition(), "NO", "NO", projectManagers.get(pm).getPayment(), 0, projectManagers.get(pm).getProject(), (com.getNumberOfProgrammersInProject(projectManagers.get(pm).getProject())+com.getNumberOfTestersInProject(projectManagers.get(pm).getProject())+ 1));
            writer.printf("%-32s%-30s%-30s%-30s%-30.2f%-30d%-30s%-10d%n", projectManagers.get(pm).getFio() , projectManagers.get(pm).getPosition(), "NO", "NO", projectManagers.get(pm).getPayment(), 0, projectManagers.get(pm).getProject(), (com.getNumberOfProgrammersInProject(projectManagers.get(pm).getProject())+com.getNumberOfTestersInProject(projectManagers.get(pm).getProject())+ 1));
        }
        //Calculate month  salary for senior manager
        ArrayList<SeniorManager> seniorManagers = com.getAllSeniorManagers();
            seniorManagers.get(0).getRate();
            seniorManagers.get(0).calculateSalaryForHeading(com.getNumberOfEmployeesInCompany());
        System.out.printf("%-32s%-30s%-30s%-30s%-30.2f%-30d%-30s%-10d%n", seniorManagers.get(0).getFio() , seniorManagers.get(0).getPosition(), "NO", "NO", seniorManagers.get(0).getPayment(), 0, "NO", com.getNumberOfEmployeesInCompany());
        writer.printf("%-32s%-30s%-30s%-30s%-30.2f%-30d%-30s%-10d%n", seniorManagers.get(0).getFio() , seniorManagers.get(0).getPosition(), "NO", "NO", seniorManagers.get(0).getPayment(), 0, "NO", com.getNumberOfEmployeesInCompany());
        //Calculate month  salary for team leaders
        ArrayList<TeamLeader> teamLeaders = com.getAllTTeamLeaders();
        for (int tl = 0; tl<teamLeaders.size(); tl++){
            String project = teamLeaders.get(tl).getProject();
            float budget = com.getBudget(project);
            float workedHours = (float) ((Math.random() * (168-84)+84));
            teamLeaders.get(tl).setWorktime(workedHours);
            teamLeaders.get(tl).getRate();
            teamLeaders.get(tl).calculateSalaryForHeading(com.getNumberOfEmployeesInProject(project));
            teamLeaders.get(tl).calculateSalaryForWorkedTime();
            teamLeaders.get(tl).setProjectTermInMonths((float) (Math.random() * 14+6));
            teamLeaders.get(tl).calculateSalaryForTheProject(teamLeaders.get(tl).getProportionOfParticipationInProject(budget),  teamLeaders.get(tl).getprojectTermInMonths());
            teamLeaders.get(tl).calculateSalary();
            System.out.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", teamLeaders.get(tl).getFio() , teamLeaders.get(tl).getPosition(), teamLeaders.get(tl).getRate(), teamLeaders.get(tl).getWorktime(), teamLeaders.get(tl).getPayment(), 0, teamLeaders.get(tl).getProject(), (com.getNumberOfProgrammersInProject(teamLeaders.get(tl).getProject())+com.getNumberOfTestersInProject(teamLeaders.get(tl).getProject())));
            writer.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", teamLeaders.get(tl).getFio() , teamLeaders.get(tl).getPosition(), teamLeaders.get(tl).getRate(), teamLeaders.get(tl).getWorktime(),  teamLeaders.get(tl).getPayment(), 0, teamLeaders.get(tl).getProject(), (com.getNumberOfProgrammersInProject(teamLeaders.get(tl).getProject())+com.getNumberOfTestersInProject(teamLeaders.get(tl).getProject())));
        }
        //Calculate month  salary for testers
        ArrayList<Tester> testers = com.getAllTesters();
        for (int t = 0; t<testers.size(); t++) {
            float workedHours = (float) ((Math.random() * (168-84)+84));
            testers.get(t).setWorktime(workedHours);
            testers.get(t).getRate();
            testers.get(t).calculateSalaryForWorkedTime();
            String project = testers.get(t).getProject();
            float budget = com.getBudget(project);
            float proportionOfParticipationInProject = testers.get(t).getProportionOfParticipationInProject(budget, (com.getNumberOfTestersInProject(project)));
            testers.get(t).setProjectTermInMonths((float) (Math.random() * (14-6)+6));
            testers.get(t).calculateSalaryForTheProject(proportionOfParticipationInProject,  testers.get(t).getprojectTermInMonths());
            testers.get(t).calculateSalary();
            System.out.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", testers.get(t).getFio(), testers.get(t).getPosition(), testers.get(t).getRate(), testers.get(t).getWorktime(), testers.get(t).getPayment(), 0, testers.get(t).getProject(), 0);
            writer.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", testers.get(t).getFio(), testers.get(t).getPosition(), testers.get(t).getRate(), testers.get(t).getWorktime(), testers.get(t).getPayment(), 0, testers.get(t).getProject(), 0);
        }
        //Calculate month  salary for programmers
        ArrayList<Programmer> programmers = com.getAllProgrammers();
        for (int p = 0; p<programmers.size(); p++) {
            float workedHours = (float) ((Math.random() * (168-84)+84));
            programmers.get(p).setWorktime(workedHours);
            programmers.get(p).getRate();
            programmers.get(p).calculateSalaryForWorkedTime();
            String project = programmers.get(p).getProject();
            float budget = com.getBudget(project);
            float proportionOfParticipationInProject = programmers.get(p).getProportionOfParticipationInProject(budget, (com.getNumberOfProgrammersInProject(project)));
            programmers.get(p).setProjectTermInMonths((float) (Math.random() * (14-6)+6));
            programmers.get(p).calculateSalaryForTheProject(proportionOfParticipationInProject,  programmers.get(p).getprojectTermInMonths());
            programmers.get(p).calculateSalary();
            System.out.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", programmers.get(p).getFio(), programmers.get(p).getPosition(), programmers.get(p).getRate(), programmers.get(p).getWorktime(), programmers.get(p).getPayment(), 0, programmers.get(p).getProject(), 0);
            writer.printf("%-32s%-30s%-30s%-30.1f%-30.2f%-30d%-30s%-10d%n", programmers.get(p).getFio(), programmers.get(p).getPosition(), programmers.get(p).getRate(), programmers.get(p).getWorktime(), programmers.get(p).getPayment(), 0, programmers.get(p).getProject(), 0);
        }
        writer.close();
    }
}


