package StaffDemo;
//абстрактный класс для всех работников занятых в проектах
abstract class OfficePlankton extends Employee {
    private Project project;

    OfficePlankton(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}
