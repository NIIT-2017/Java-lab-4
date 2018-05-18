import StaffDemo.*;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Programm {
    public static void main(String[] args) {
        Staff staff = new Staff(new File("src/main/resources/data.xml"),new File("src/main/resources/projects.xml"));
        //заполнить поля рандомно
        setField(staff.getProjects(), staff.getEmployees());
        //вычисляем зарблату у каждого
        for (Employee nextEmployee : staff.getEmployees()) {
            nextEmployee.calcPayment();
        }
        //отрисовка таблицы
        drawJFrame(staff.getEmployees());
    }

    private static void setField(ArrayList<Project> projects, ArrayList<Employee> staff) {
        SeniorManager seniorManager = SeniorManager.getSeniorManager(staff);
        ArrayList<ProjectManager> projectManagers = ProjectManager.getProjectManagers(staff);
        ArrayList<TeamLeader> teamLeaders = TeamLeader.getTeamLeaders(staff);
        ArrayList<Programmer> programmers = Programmer.getProgrammers(staff);
        ArrayList<Manager> managers = Manager.getManagers(staff);
        ArrayList<Tester> testers = Tester.getTesters(staff);
        ArrayList<Driver> drivers = Driver.getDrivers(staff);
        ArrayList<Cleaner> cleaners = Cleaner.getCleaners(staff);
        Random random = new Random();
        //заполяем поля проекта
        for (int i = 0; i < projects.size(); i++) {
            projects.get(i).setTeamLeader(teamLeaders.get(i));
            projects.get(i).setProjectManager(projectManagers.get(i));
            projects.get(i).addOfficeplankton(managers.subList(i*2,i*2+2));
            projects.get(i).addOfficeplankton(programmers.subList(i*5,i*5+5));
            projects.get(i).addOfficeplankton(testers.subList(i*5,i*5+5));
        }
        //назначить проекты и ставку за подчиненного
        if (seniorManager != null) {
            seniorManager.setProjects(projects);
            seniorManager.setRatePerProject(50000);
        }

        for (ProjectManager projectManager : projectManagers) {
            projectManager.setRatePerProject(0.2+0.1*random.nextDouble());
            projectManager.setRatePerEmployees(6000);
        }
        for (TeamLeader teamLeader : teamLeaders) {
            teamLeader.setRatePerEmployees(1000);
            teamLeader.setOvertimeHours(10*random.nextDouble());
            teamLeader.setRateOvertimeHour(500);
            teamLeader.setRatePerProject(0.01+0.02*random.nextDouble());
            teamLeader.setWorkHours(150+10*random.nextDouble());
            teamLeader.setRateWorkHour(300);
        }
        for (Programmer programmer : programmers) {
            programmer.setOvertimeHours(10*random.nextDouble());
            programmer.setRateOvertimeHour(500);
            programmer.setRatePerProject(0.01+0.02*random.nextDouble());
            programmer.setWorkHours(150+10*random.nextDouble());
            programmer.setRateWorkHour(300);
        }
        for (Tester tester : testers) {
            tester.setRateWorkHour(300);
            tester.setWorkHours(160);
            tester.setRatePerProject(0.02*random.nextDouble());
        }
        for (Manager manager : managers) {
            manager.setRatePerProject(0.2+0.05*random.nextDouble());
        }
        for (Driver driver : drivers) {
            driver.setWorkHours(100);
            driver.setRateWorkHour(150);
            driver.setOverTimeHours(30*random.nextDouble());
            driver.setRateOverTimeHour(250);
        }
        for (Cleaner cleaner : cleaners) {
            cleaner.setWorkHours(20);
            cleaner.setRateWorkHour(600);
        }
    }

    private static void drawJFrame(ArrayList<Employee> staff) {
        JFrame window = new JFrame("Расчет выплат");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(550,800);
        //window.setLayout(new FlowLayout());
        JTable table = new JTable();
        Model model = new Model(staff);
        table.setModel(model);
        window.add(table);
        window.setContentPane(new JScrollPane(table));
        window.setVisible(true);
    }

    static class Model implements TableModel {
        ArrayList<Employee> staff;

        Model(ArrayList<Employee> staff) {
            this.staff = staff;
        }

        public int getRowCount() {
            return staff.size();
        }

        public int getColumnCount() {
            return 5;
        }

        public String getColumnName(int i) {
            switch (i) {
                case 0:
                    return "Фамилия";
                case 1:
                    return "Имя";
                case 2:
                    return "Отчество";
                case 3:
                    return "Должность";
                case 4:
                    return "Зряплата";
            }
            return null;
        }

        public Class<?> getColumnClass(int i) {
            return String.class;
        }

        public boolean isCellEditable(int i, int i1) {
            return false;
        }

        public Object getValueAt(int i, int i1) {
            String value= "";
            if (i1<3)value = staff.get(i).getFIO()[i1];
            else if (i1==3){
                value = staff.get(i).getClass().getSimpleName();
            }
            else if (i1==4){
                BigDecimal bigDecimal = new BigDecimal(staff.get(i).getPayment());
                value = bigDecimal.setScale(2,BigDecimal.ROUND_DOWN).toString();
            }
            return value;
        }

        public void setValueAt(Object o, int i, int i1) {

        }

        public void addTableModelListener(TableModelListener tableModelListener) {

        }

        public void removeTableModelListener(TableModelListener tableModelListener) {

        }
    }
}
