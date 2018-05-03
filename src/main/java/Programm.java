import StaffDemo.*;
import org.w3c.dom.*;
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

public class Programm {


    public static void main(String[] args) {
        ArrayList<Project> projects = readProjectsFromFIle(new File("src/main/resources/projects.xml"));
        ArrayList<Employee> staff = readStaffFromFile(new File("src/main/resources/data.xml"));


        ArrayList<SeniorManager> seniorManagers = SeniorManager.getSeniorManagers(staff);
        ArrayList<ProjectManager> projectManagers = ProjectManager.getProjectManagers(staff);
        ArrayList<TeamLeader> teamLeaders = TeamLeader.getTeamLeaders(staff);
        ArrayList<Programmer> programmers = Programmer.getProgrammers(staff);
        ArrayList<Manager> managers = Manager.getManagers(staff);
        ArrayList<Tester> testers = Tester.getTesters(staff);

        //заполяем поля проекта
        for (int i = 0; i < projects.size(); i++) {
            projects.get(i).setTeamLeader(teamLeaders.get(i));
            projects.get(i).setProjectManager(projectManagers.get(i));
            projects.get(i).addManagers(managers.subList(i*2,i*2+2));
            projects.get(i).addProgrammers(programmers.subList(i*5,i*5+5));
            projects.get(i).addTesters(testers.subList(i*5,i*5+5));
        }

        for (Employee enginer : projects.get(0).getEmployee()) {
        }
        //назанчаем личный вклад

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
                newEntry.setAttribute("name", aStaff.getFIO()[0]);
                newEntry.setAttribute("secondname", aStaff.getFIO()[1]);
                newEntry.setAttribute("surname", aStaff.getFIO()[2]);
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
}

/*
53
прочитать данные о сотрудниках из файла
создать 3 проекта
создать 15 программистов
создать 15 тестировщиков
создать 3 Лидера (1 лидер на 10 человек)
создать 8 водителей
создать 5 уборщика
создать 6 менаджера(по 2 на проект)
соать проектрого менаджера по 1 на проект
содать руководителья направления
расчиттать з/п для всех сотрудников
вывести в виде таблицы
*/
