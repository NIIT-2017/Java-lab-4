package Employees;

import java.util.ArrayList;

public class Company {
    private ArrayList<Project> projects;
    private ArrayList<Personal> personal;
    private String title;

    public Company()
    {
        personal=new ArrayList<>();
        projects=new ArrayList<>();
    }

    public void addPersonal(Personal person)
    {
        personal.add(person);
    }
    public void addProject(Project project)
    {
        projects.add(project);
    }
    public void setTitle(String title)
    {
        this.title=title;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public ArrayList<Project> getProjects()
    {
        return  projects;
    }
    public String getTitle() {
        return title;
    }
}
