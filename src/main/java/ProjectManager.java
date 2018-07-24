public class ProjectManager extends Manager implements Heading {
    static int countProjManag = 0;

    ProjectManager(){
        super();
    }

    ProjectManager(int id, String name){
        super(id, name);
        countManag--;
        countProjManag++;
    }


    public int calcPayAtProg() {
        return Manager.countManag*1000;
    }

    public int calcPay() {
        return calcPayAtProj() + calcPayAtProg();
    }
}
