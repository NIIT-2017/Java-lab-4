public class PrintPayment {

    public static void main(String[] args) {
        Creation creation = new Creation();
        creation.projectCreation();
        Info info = creation.info;
        info.calculatePayment();
        for (int i = 0; i < info.allProjects.size(); i++) {
            info.allProjects.get(i).searchNumberEngineer();
            info.allProjects.get(i).searchNumberManager();
        }
        info.printPayment();
    }
}
