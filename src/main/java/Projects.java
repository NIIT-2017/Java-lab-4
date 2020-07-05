public class Projects {
    private String name;
    private int finance;

  public Projects(String name, int finance){
      this.name    = name;
      this.finance = finance;
  }

  public int getFinance() {
      return finance;
  }

  public String getName(){
      return name;
  }

}