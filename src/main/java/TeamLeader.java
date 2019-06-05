public class TeamLeader extends Programmer implements Heading{
    private int numofsubord;

    public TeamLeader(int id, String name, String position, int base, int project, double part, int numofsubord) {
        super(id, name, position, base, project, part);
        this.setNumofsubord(numofsubord);
    }

    public void calc() {
        this.setPayment((wtPayment(this.getBase(),this.getWorktime()))+(proPyment(this.getProject(),this.getPart())) + hdPyment(this.getNumofsubord(), this.getBase()));
    }


    public int getNumofsubord() {
        return numofsubord;
    }

    public void setNumofsubord(int numofsubord) {
        this.numofsubord = numofsubord;
    }

    public int hdPyment(int numofsubord, int surcharge) {
        int hdpyment = numofsubord*surcharge;
        return hdpyment;
    }
}
