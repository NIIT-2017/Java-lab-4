public class ProjectManager extends Manager implements Heading{
    protected int head = 10;
    public ProjectManager (int id, String name, int projectBudget){
        super(id, name, projectBudget);
    }

    public int calcHeading() {
        return head * PriceHead;
    }

    @Override
    protected int calcPayment() {
        return CalcProject() + calcHeading();
    }
}
