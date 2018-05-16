package StaffDemo;
//галвный класс проекта

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Staff {
    //последний занятый номер работника
    private static int LASTID =0;
    //хранит и управляем списками сотрудников и проектов
    private ArrayList<Project> projects;
    private ArrayList<Employee> employees;

    public Staff() {
        this.employees = new ArrayList<Employee>();
        this.projects = new ArrayList<Project>();
    }

    public Staff(File data, File project) {
        this.employees = readStaffFromFile(data);
        this.projects = readProjectsFromFIle(project);
    }

    //добавить одного сотрудника в штат
    public void addEmployee(Employee employee) {
        boolean result = true;
        if (employee==null) result = false;
        else {
            if (employee.getID() < 0) result = false;
            if (employee.getID() == 0) employee.setID(++LASTID);
            if (employee.getFIO() == null) result = false;
            else {
                if (employee.getFIO()[0].trim().equals("")) result = false;
                if (employee.getFIO()[1].trim().equals("")) result = false;
                if (employee.getFIO()[2].trim().equals("")) result = false;
            }
        }
        if (result)this.employees.add(employee);
    }

    //добавить список сотрудников в штат
    public void addEmployees(List<Employee> employees) {
        if (employees!=null)
        {
            for (Employee next : employees) {
                this.addEmployee(next);
            }
        }
    }

    //добавить один проект
    public void addProject(Project project) {
        boolean result = true;
        if (project==null) result = false;
        else {
            if (project.getName().trim().equals("")) result = false;
            if (project.getBudget()<=0) result = false;
        }
        if (result)this.projects.add(project);
    }

    //добавить проекты списком
    public void addProjects(List<Project> projects) {
        if (projects != null) {
            for (Project next : projects) {
                this.addProject(next);
            }
        }
    }

    //прочитать список проектов из файла
    private ArrayList<Project> readProjectsFromFIle(File data) {
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

    //прочитать список сотрудников из проекта
    private ArrayList<Employee> readStaffFromFile(File data){
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
    //прочитьать из XML список по тегу

    private NodeList readFromXML(File file,String tag) {
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
    //записать данные в файл

    private void writeDataToXML(File data) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = document.createElement("employers");
            document.appendChild(root);
            for (Employee aStaff : employees) {
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

    //гетер для работников
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<Employee>(employees);
    }
    //гетер для проектов
    public ArrayList<Project> getProjects() {
        return new ArrayList<Project>(projects);
    }
}
