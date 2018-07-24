 public class Manager extends Employee implements Project {
    static int countManag = 0;
     Manager(){
         super();
     }
     Manager(int id, String name){
         super();
         countManag++;
         this.id = id;
         this.name = name;
     }
     public int calcPayAtProj() {
         return (int) (0.1*cash);
     }

     public int calcPay() {
         return calcPayAtProj();
     }
 }
