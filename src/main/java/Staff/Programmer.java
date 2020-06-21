package Staff;

class Programmer extends Engineer {

    //constructor
    public Programmer(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, workTime, company);
        position = "Programmer";
    }
    //---------------------------------------------------------
}
