import StaffDemo.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Programm {
    public static void main(String[] args) {
        ArrayList<Project> projects = readProjectsFromFIle(new File("src/main/resources/projects.xml"));
        ArrayList<Employee> staff = readStaffFromFile(new File("src/main/resources/data.xml"));
        //заполнить поля рандомно
        setField(projects, staff);
        //вычисляем зарблату у каждого
        for (Employee nextEmployee : staff) {
            nextEmployee.calcPayment();
        }
        //отрисовка таблицы
        drawJFrame(staff);
        System.out.println("Welcome to the StaffDemo");
    }

    private static ArrayList<Project> readProjectsFromFIle(File data) {
        ArrayList<Project> projects = new ArrayList<Project>();
        NodeList list = readFromXML(data, "project");
        if (list != null) {
            for (int i = 0; i < list.getLength(); i++) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                projects.add(new Project(
                        attributes.getNamedItem("title").getNodeValue(),
                        Integer.parseInt(attributes.getNamedItem("budget").getNodeValue())));
            }
        }
        return projects;
    }

    private static ArrayList<Employee> readStaffFromFile(File data){
        ArrayList<Employee> staff = new ArrayList<Employee>();
        NodeList list = readFromXML(data, "employee");
        if (list != null) {
            for (int i = 0; i < list.getLength(); i++) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                String s = attributes.getNamedItem("position").getNodeValue();
                if ("Programmer".equals(s)) {
                    staff.add(new Programmer(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("Tester".equals(s)) {
                    staff.add(new Tester(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("Driver".equals(s)) {
                    staff.add(new Driver(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("Manager".equals(s)) {
                    staff.add(new Manager(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("Cleaner".equals(s)) {
                    staff.add(new Cleaner(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("TeamLeader".equals(s)) {
                    staff.add(new TeamLeader(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("ProjectManager".equals(s)) {
                    staff.add(new ProjectManager(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                } else if ("SeniorManager".equals(s)) {
                    staff.add(new SeniorManager(
                            attributes.getNamedItem("ID").getNodeValue(),
                            attributes.getNamedItem("surname").getNodeValue(),
                            attributes.getNamedItem("name").getNodeValue(),
                            attributes.getNamedItem("secondname").getNodeValue()));
                }
            }
        }
        return staff;
    }

    private static void writeDataToXML(ArrayList<Employee> staff) {
        File data = new File("src/main/resources/data.xml");
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = document.createElement("employers");
            document.appendChild(root);
            for (Employee aStaff : staff) {
                Element newEntry = document.createElement("employer");
                newEntry.setAttribute("ID", Integer.toString(aStaff.getID()));
                newEntry.setAttribute("surname", aStaff.getFIO()[0]);
                newEntry.setAttribute("name", aStaff.getFIO()[1]);
                newEntry.setAttribute("secondname", aStaff.getFIO()[2]);
                newEntry.setAttribute("position", aStaff.getClass().getSimpleName());

                root.appendChild(newEntry);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(new DOMSource(document),new StreamResult(data));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static NodeList readFromXML(File file,String tag) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            Element root = doc.getDocumentElement();
            return root.getElementsByTagName(tag);

        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        }
        return null;
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
            teamLeader.setRatePerWorkHour(300);
        }
        for (Programmer programmer : programmers) {
            programmer.setOvertimeHours(10*random.nextDouble());
            programmer.setRateOvertimeHour(500);
            programmer.setRatePerProject(0.01+0.02*random.nextDouble());
            programmer.setWorkHours(150+10*random.nextDouble());
            programmer.setRateDayHours(300);
        }
        for (Tester tester : testers) {
            tester.setRatePerWorkHour(300);
            tester.setWorkHours(160);
            tester.setRatePerProject(0.02*random.nextDouble());
        }
        for (Manager manager : managers) {
            manager.setRatePerProject(0.2+0.05*random.nextDouble());
        }
        for (Driver driver : drivers) {
            driver.setWorkHours(100);
            driver.setRatePerWorkHour(150);
            driver.setOverTimeHours(30*random.nextDouble());
            driver.setRateOverTimeHour(250);
        }
        for (Cleaner cleaner : cleaners) {
            cleaner.setWorkHours(20);
            cleaner.setRatePerWorkHour(600);
        }
    }

    private static void drawJFrame(ArrayList<Employee> staff) {
        JFrame window = new JFrame("Расчет выплат");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,600);
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
