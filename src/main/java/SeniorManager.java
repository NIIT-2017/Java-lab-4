public class SeniorManager extends ProjectManager {
    SeniorManager(){
        super();
    }

    SeniorManager(int id, String name){
        super(id, name);
        countProjManag--;
    }

    @Override
    public int calcPayAtProg() {
        return countProjManag*2000;
    }

    @Override
    public int calcPayAtProj() {
        return (int) (0.2*cash);
    }

    @Override
    public int calcPay() {
        return calcPayAtProg() + calcPayAtProj();
    }
}
