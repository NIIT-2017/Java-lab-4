import StaffDemo.*;
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

public class Programm {


    public static void main(String[] args) {
        createStaff();
        System.out.println("Welcome to the StaffDemo");

        Project project1 = new Project("Project1", 10000);
        Project project2 = new Project("Project2", 10000);

        Cleaner cleaner = new Cleaner("Иванов", "Иван", "Иванович");
        cleaner.setDayWorkHours(8);
        cleaner.setRatePerDayHours(50);

        Driver driver = new Driver("Петров", "Петр", "петрович");
        driver.setNightWorkHours(4);
        driver.setRatePerNightHours(120);
        driver.setDayWorkHours(8);
        driver.setDayWorkHours(80);

        Programmer programmer1 = new Programmer("Surname1", "Name1", "Secondname1");
        programmer1.addWork(project1, 0.03);
        programmer1.addWork(project2, 0.01);

        Programmer programmer2 = new Programmer("Surname2", "Name2", "Secondname2");
        programmer2.addWork(project1, 0.02);

        Programmer programmer3 = new Programmer("Surname3", "Name3", "Secondname3");
        programmer3.addWork(project1, 0.05);

        Programmer programmer4 = new Programmer("Surname4", "Name4", "Secondname4");
        programmer4.addWork(project2, 0.01);

        Programmer programmer5 = new Programmer("Surname5", "Name5", "Secondname5");
        programmer5.addWork(project2, 0.06);

        TeamLeader leader1 = new TeamLeader("leaderSurname1", "LeaderName1", "leaderSecondname1");
        leader1.setRateForProgrammer(8);
        leader1.setProject(project1);

        TeamLeader leader2 = new TeamLeader("leaderSurname2", "LeaderName2", "leaderSecondname2");
        leader2.setRateForProgrammer(8);
        leader2.setProject(project2);

    }

    private static void createStaff() {
        ArrayList<Employee> staff = new ArrayList<Employee>();
        NodeList list = readFromXML(new File("src/main/resources/emploers.xml"));
        for (int i = 0; i < 54; i++) {
            if (i < 15) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new Programmer(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 30) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new Tester(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 38) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new Driver(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 42) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new Manager(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 47) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new Cleaner(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 50) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new TeamLeader(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 53) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new ProjectManager(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
            else if (i < 54) {
                NamedNodeMap attributes = list.item(i).getAttributes();
                staff.add(new SeniorManager(
                        attributes.getNamedItem("surname").getNodeValue(),
                        attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("secondname").getNodeValue()));
            }
        }
        writeDataToXML(staff);
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

    private static NodeList readFromXML(File file) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            Element root = doc.getDocumentElement();
            return root.getElementsByTagName("emploer");

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
