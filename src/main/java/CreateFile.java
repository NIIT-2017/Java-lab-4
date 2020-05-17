import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateFile {
    final private int BASE_ID = 1;
    public ArrayList<String> staff = new ArrayList<String>();
    public ArrayList<String> position = new ArrayList<String>();
    public ArrayList<Integer> id = new ArrayList<Integer>();
    public ArrayList<Integer> base = new ArrayList<Integer>();
    public ArrayList<String> projects = new ArrayList<String>();

    public CreateFile() {

    }

    protected ArrayList<String> createListFioStaff() {
        String[] fioPersonal = {"Казаков Фёдор Дмитриевич", "Котовский Цефас Анатольевич", "Шарапов Марк Андреевич", "Худобяк Болеслав Романович", "Гаврилов Богдан Ярославович", "Горобчук Захар Сергеевич", "Фёдоров Филипп Борисович", "Кабанов Никодим Иванович",
                "Ершов Спартак Вадимович", "Пономаренко Фёдор Андреевич", "Лаврентьев Данила Алексеевич", "Плаксий Арсений Петрович", "Гаврилов Август Иванович", "Зайцев Харитон Артёмович", "Николаева Оксана Брониславовна", "Белобокина Доминика Леонидовна", "Яковлева Василиса Валериевна", "Сердюк Вера Леонидовна",
                "Кашина Любовь Алексеевна", "Собакина Марфа Петровна", "Волкова Татьяна Дмитриевна", "Цветкова Юлия Ивановна", "Белова Мария Фёдорвна", "Николаева Алла Алексеевна", "Ткаченко Надежда Станиславовна",
                "Давыдова Евгения Эдуардовна", "Хорошева Мая Дмитриевна", "Разгильдяев Станислав Петрович", "Мишина Розалина Фёдоровна", "Шарова Злата Вадимовна", "Шестаков Афанасий Эдуардович", "Нестеров Тимур Владимирович", "Юдин Юрий Богданович", "Лаврентьев Пётр Евгеньевич", "Бирюков Евдоким Леонидович", "Шашков Яков Данилович", "Ерёменко Яков Дмитриевич", "Устинов Лаврентий Викторович", "Бутко Тимур Анатолиевич", "Артемьев Герман Львович", "Герасимов Корнелий Эдуардович", "Кулаков Филипп Иванович", "Суворов Устин Леонидович", "Пожарова Анна Викторовна", "Ермошкина Фёкла Львовна", "Дубина Юлия Дмитриевна", "Кудрявцева Василиса Викторовна", "Масловска Богдана Михайловна", "Григорьева Инна Михайловна", "Шубина Юнона Григорьевна", "Самсонова Арина Романовна", "Сыпченко Олеся Фёдоровна",};
        for (String fio : fioPersonal) {
            staff.add(fio);
        }
        return staff;
    }

    protected ArrayList<Integer> createListId() {
        for (int i = 1; i < 51; i++) {
            id.add(i);
        }
        return id;
    }

    protected ArrayList createListPosition() {
        String[] pos = {"Cleaner", "Driver", "Programmer", "Tester", "TeamLeader", "ProjectManager", "SeniorManager"};
        for (String p : pos) {
            position.add(p);
        }
        return position;
    }

    protected ArrayList<Integer> createListBase() {
        //Cleaner
        base.add(400);
        //Driver
        base.add(500);
        //TeamLeader
        base.add(950);
        //Programmer
        base.add(750);
        //Tester
        base.add(600);
        return base;
    }

    protected ArrayList<String> createListProjects() {
        String[] pro = {"SmartWatch", "SmartScales", "SmartKeys"};
        for (String p : pro) {
            projects.add(p);
        }
        return projects;
    }

    public void createNewJSONFile(String fileName) {
        JSONArray staffArray = new JSONArray();
        ArrayList<String> names = staff;
        ArrayList<String> projects = createListProjects();
        int pmj =0;
        int smj =0;
        int tmj =0;
        for (int i = 0; i < names.size(); i++) {
            JSONObject person = new JSONObject();
            person.put("id", BASE_ID + i);
            person.put("name", names.get(i));
            if(i>=0 && i<2){
                //Cleaner
                person.put("position", "Cleaner");
                person.put("base", 400);
            }
            if(i>=2 && i<4){
                //Driver
                person.put("position", "Driver");
                person.put("base", 500);
            }
            if(i==4){
                //Senior Manager
                person.put("position", "Senior Manager");
            }
            if(i>=5 && i<8){
                //Project Manager
                person.put("position", "Project Manager");
                person.put("project", projects.get(pmj));
                pmj += 1;
            }
            if(i>=8 && i<11){
                //Simple Manager
                person.put("position", "Manager");
                person.put("project", projects.get(smj));
                smj += 1;
            }
            if(i>=11 && i<14){
                //Team Leader
                person.put("position", "Team Leader");
                person.put("base", 950);
                person.put("project", projects.get(tmj));
                tmj += 1;
            }
            if(i>=14 && i<26){
                int start_i = 14;
                //QA
                person.put("position", "QA");
                person.put("base", 650);
                int bunch = (26-start_i)/projects.size();
                if (i>=start_i && i< start_i+bunch){
                    person.put("project", projects.get(0));
                }
                else if (i>=start_i+bunch && i< start_i+bunch*2){
                    person.put("project", projects.get(1));
                }
                else{
                    person.put("project", projects.get(2));
                }
            }
            if(i>=26){
                int start_i = 26;
                //Programmer
                person.put("position", "Programmer");
                person.put("base", 900);
                int bunch = ( names.size()-start_i)/projects.size();
                if (i>=start_i && i< start_i+bunch){
                    person.put("project", projects.get(0));
                }
                else if (i>=start_i+bunch && i< start_i+bunch*2){
                    person.put("project", projects.get(1));
                }
                else{
                    person.put("project", projects.get(2));
                }
            }
            staffArray.put(person);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("StaffList.json"))) {
            bw.write(staffArray.toString(4));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        int q =0;
    }


    public static void main(String[] args) {
        CreateFile file = new CreateFile();
        System.out.println(file.createListFioStaff());
        System.out.println(file.createListId());
        System.out.println(file.createListBase());
        System.out.println(file.createListPosition());
        System.out.println(file.createListProjects());
        file.createNewJSONFile("some_name.json");
    }
}
