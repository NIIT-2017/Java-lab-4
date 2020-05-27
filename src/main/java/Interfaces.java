import java.util.Set;

interface WorkTime{
    //Calculates part of payment for worktime
    float moneyForWorktime();
    int getBase();
}

interface Project{
    //Calculates part of payment for projects
    float moneyForProjects();
    //Joins to a project
    boolean setProject(String projectTitle);
    Set<String> getProjects();
}

interface Heading{
    //Calculates part of payment for heading
    float moneyForHeading();
    //Assigns subordinate staff
    boolean setSubordinateStaff(int id);
    Set<Integer> getSubordinateStaff();
}