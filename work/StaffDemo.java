//Lab4
//Efremov Pavel

import java.io.*;
import java.util.ArrayList;

public class StaffDemo {
    public static void main (String args[]){
        ArrayList <Employee> staff = new ArrayList();
        try {
            String pathText = "D:\\java_work\\javalab4\\src\\main\\resources\\staff.txt";
            File file = new File(pathText);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] str;

            while ((line = bufferedReader.readLine()) != null) {
                str = line.split("/");
                if (str[3].equals("уборщик")){
                    staff.add(new Cleaner(Integer.parseInt(str[1]),str[2],str[3],Integer.parseInt(str[4])));
                } else
                if (str[3].equals("водитель")){
                    staff.add(new Driver(Integer.parseInt(str[1]),str[2],str[3],Integer.parseInt(str[4])));
                } else
                if (str[3].equals("программист")){
                    staff.add(new Programmer(Integer.parseInt(str[1]),str[2],str[3],
                                             Integer.parseInt(str[4]),
                                             Integer.parseInt(str[5]),
                                             PROJECTS.valueOf(str[6])));
                } else
                if (str[3].equals("тестер")){
                    staff.add(new Tester(Integer.parseInt(str[1]),str[2],str[3],
                                         Integer.parseInt(str[4]),
                                         Integer.parseInt(str[5]),
                                         PROJECTS.valueOf(str[6])));
                } else
                if (str[3].equals("тимлидер")){
                    staff.add(new TeamLeader(Integer.parseInt(str[1]),str[2],str[3],
                                             Integer.parseInt(str[4]),
                                             Integer.parseInt(str[5]),
                                             PROJECTS.valueOf(str[6]),
                                             Integer.parseInt(str[7])));
                } else
                if (str[3].equals("менеджер")){
                    staff.add(new Manager(Integer.parseInt(str[1]),str[2],str[3],
                                          Integer.parseInt(str[4]),
                                          PROJECTS.valueOf(str[5])));
                } else
                if (str[3].equals("менеджер проекта")){
                    staff.add(new ProjectManager(Integer.parseInt(str[1]),str[2],str[3],
                                                 Integer.parseInt(str[4]),
                                                 PROJECTS.valueOf(str[5]),
                                                 Integer.parseInt(str[6])));
                } else
                if (str[3].equals("главный менеджер")){
                    staff.add(new SeniorManager(Integer.parseInt(str[1]),str[2],str[3],
                                                Integer.parseInt(str[4]),
                                                PROJECTS.valueOf(str[5]),
                                                Integer.parseInt(str[6])));
                }
            }
            fileReader.close();
        }
        catch (IOException e) {e.printStackTrace();}
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-35s%-20s%-10s%n","| ФИО","| Должность","| Зарплата |");
        System.out.println("-------------------------------------------------------------------");

        for (Employee emp: staff){
            emp.addTime(120);
            emp.totalPayment();
            System.out.printf("%-35s%-20s%-10s%-10s%n","| "+emp.name,"| "+emp.position,"| "+emp.payment," |");
        }
        System.out.println("-------------------------------------------------------------------");
        try{
            String pathText = "D:\\java_work\\javalab4\\src\\main\\resources\\staffResult.txt";
            Writer file = new FileWriter(pathText,true);

            String temp = "-------------------------------------------------------------------\r\n";
            file.write(temp);
            temp = String.format("%-35s%-20s%-10s%n","| ФИО","| Должность","| Зарплата |");
            file.write(temp);
            temp = "-------------------------------------------------------------------\r\n";
            file.write(temp);

            for (Employee emp: staff){
                temp=String.format("%-35s%-20s%-10s%-10s%n","| "+emp.name,"| "+emp.position,"| "+emp.payment," |");
                file.write(temp);
            }
            temp = "-------------------------------------------------------------------";
            file.write(temp);
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


