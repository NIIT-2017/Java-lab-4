
public class task {
    public static void main(String[] args) {
        Bookkeeping two = new Bookkeeping();
        two.readJson("employee.json");
        for(int i = 0; i < two.getBook().size(); i++){
            System.out.println (two.getBook(i).getName() +" " + two.getBook(i).getPosition() +" " + two.getBook(i).getWorktime() +" " + two.getBook(i).getPayment());
        }
         /*Bookkeeping one = new Bookkeeping();
        one.setDriverList((byte)1, "Колосов Николай", (short)80);
        one.setDriverList((byte)2, "Варрава Сергей", (short)80);
        one.setCleanerList((byte)3, "Изотова Гульнара", (short)50);
        one.setCleanerList((byte)4, "Павлова Наталья", (short)50);
        one.setProgrammerList((byte)5, "Поливанова Виктория", (short)100, (byte)15,"Typescript");
        one.setProgrammerList((byte)6, "Соболев Андрей", (short)100, (byte)15,"Typescript");
        one.setProgrammerList((byte)7, "Карпов Николай", (short)100, (byte)15,"Typescript");
        one.setTesterList((byte)8, "Кузьмин Никита", (short)100, (byte)10,"Typescript");
        one.setTesterList((byte)9, "Фадеева Эмма", (short)100, (byte)10,"Typescript");
        one.setTeamLeaderList((byte)10, "Королев Сергей", (short)100, (byte)10,"Typescript", (byte)5);
        one.setManagerList((byte)11, "Никифоров Игорь", (byte)10,"Typescript");
        one.setProjectManagerList((byte)12, "Никитин Павел", (byte)10,"Typescript", (byte)6);
        one.setProgrammerList((byte)13, "Семенов Антон", (short)100, (byte)15,"C++");
        one.setProgrammerList((byte)14, "Шилов Глеб", (short)100, (byte)15,"C++");
        one.setProgrammerList((byte)15, "Наумов Вадим", (short)100, (byte)15,"C++");
        one.setTesterList((byte)16, "Панова Ирина", (short)100, (byte)10,"C++");
        one.setTesterList((byte)17, "Колесникова Елизавета", (short)100, (byte)10,"C++");
        one.setTeamLeaderList((byte)18, "Беляков Богдан", (short)100, (byte)10,"C++", (byte)5);
        one.setManagerList((byte)19, "Хохлов Глеб", (byte)10,"C++");
        one.setProjectManagerList((byte)20, "Сазонов Тимур", (byte)10,"C++", (byte)6);
        one.setProgrammerList((byte)21, "Кулакова Наталья", (short)100, (byte)15,"Java database");
        one.setProgrammerList((byte)22, "Гусев Леонид", (short)100, (byte)15,"Java database");
        one.setProgrammerList((byte)23, "Капустин Василий", (short)100, (byte)15,"Java database");
        one.setTesterList((byte)24, "Сидорова Галина", (short)100, (byte)10,"Java database");
        one.setTesterList((byte)25, "Степанова Наталья", (short)100, (byte)10,"Java database");
        one.setTeamLeaderList((byte)26, "Морозова Юлия", (short)100, (byte)10,"Java database", (byte)5);
        one.setManagerList((byte)27, "Данилов Иван", (byte)10,"Java database");
        one.setProjectManagerList((byte)28, "Савин Игорь", (byte)10,"Java database", (byte)6);
        one.setSeniorManagerList((byte)29,"Юдин Данила", (byte)10, "Java database", (byte)10, "Typescript", (byte)10, "C++", (byte)24);
        one.createJson("employee.json");

        one = null;*/
    }

}
