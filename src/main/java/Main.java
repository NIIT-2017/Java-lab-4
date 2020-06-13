public class Main {

    public static void main(String[]args) {
        Controller.init();

        Controller.controller.addWorker();
        Controller.controller.updated();
    }
}
