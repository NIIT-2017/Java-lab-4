import java.util.ArrayList;
import java.util.List;

public class Info {

    List<Projects> allProjects = new ArrayList<Projects>();

    public List<Projects> getAllProjects() {
        return allProjects;
    }
    public void setAllProjects(List<Projects> allProjects) {
        this.allProjects = allProjects;
    }

    public void printPayment() {
        for (int i = 0; i < allProjects.size(); i++ ) {
            System.out.println(allProjects.get(i).getName());
            System.out.println(" fio - worktime - payment");
            for (int j = 0; j<allProjects.get(i).getEmployee().size(); j++) {
                System.out.println(allProjects.get(i).getEmployee().get(j).getFio()+" "+
                        allProjects.get(i).getEmployee().get(j).getWorktime()+" ч "+
                        allProjects.get(i).getEmployee().get(j).getPayment()+" р.");
            }
        }
    }

    public void calculatePayment() {
        for (int i = 0; i < allProjects.size(); i++ ) {
            for (int j = 0; j<allProjects.get(i).getEmployee().size(); j++)
                {
                allProjects.get(i).getEmployee().get(j).calculatePayment(allProjects.get(i).getCost());
            }
        }
    }

}
