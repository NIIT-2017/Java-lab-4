public class lab4 {
    public static void main(String[] args) {
        String JSONfileDirection;
        if (args.length != 0)
            JSONfileDirection = args[0];
        else
            JSONfileDirection = "./src/main/resources/stuff.json";

        Stuff stuff = new Stuff();
        stuff.getStuffFromJson(JSONfileDirection);
        stuff.createHeading();
        stuff.calcPayments();
        stuff.outputStuff(System.out);
    }
}
