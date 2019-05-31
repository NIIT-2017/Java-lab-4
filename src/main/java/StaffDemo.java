public class StaffDemo {
    public static void main(String[] args) {
        Staff myStaff = new Staff("staff.json", "projects.json");
        myStaff.calcPaymentForAllStaff(168);
        myStaff.printData();
    }
}
