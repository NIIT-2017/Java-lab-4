public class Projects {
    private int budget;
    private String name;

    public Projects (String name, int budget){
        this.name = name;
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public String getName(){
        return name;
    }
}
