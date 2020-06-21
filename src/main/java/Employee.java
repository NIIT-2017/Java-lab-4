import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "position")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Manager.class, name = "Manager"),
        @JsonSubTypes.Type(value = Personal.class, name = "Personal"),
        @JsonSubTypes.Type(value = Cleaner.class, name = "Cleaner"),
        @JsonSubTypes.Type(value = Driver.class, name = "Driver"),
        @JsonSubTypes.Type(value = Programmer.class, name = "Programmer"),
        @JsonSubTypes.Type(value = Tester.class, name = "Tester"),
        @JsonSubTypes.Type(value = TeamLeader.class, name = "TeamLeader"),
        @JsonSubTypes.Type(value = ProjectManager.class, name = "ProjectManager"),
        @JsonSubTypes.Type(value = SeniorManager.class, name = "SeniorManager")
})
public class Employee { //работник. Основной родительский класс для всех разновидностей работников.
   protected int id; //идентификационный номер.
   protected String fio; //ФИО.
   protected int worktime; //отработанное время.
   protected int payment; //заработная плата.
   protected int base;
   protected  double projectIndex;
   String project;

   public void calculatePayment(int cost) {
       payment = 0;
   }

    public double getProjectIndex() {
        return projectIndex;
    }

    public void setProjectIndex(double projectIndex) {
        this.projectIndex = projectIndex;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}




