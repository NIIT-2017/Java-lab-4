public class StaffDemo {
    public static void main(String[] args) {
        MakeStaff staff = new MakeStaff("staff.json");
        System.out.format("%5s%25s%20s%10s%15s\n", "ID", "Name", "Position", "Worktime", "Payment");
        for (Employee emp : staff.employees) {
            emp.calc();
            System.out.format("%5d%25s%20s%10d%15d\n", emp.getId(), emp.getName(), emp.getPosition(), emp.getWorktime(), emp.getPayment());
        }
    }
}
