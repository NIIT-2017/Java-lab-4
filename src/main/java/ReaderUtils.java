import java.io.*;

public class ReaderUtils {
    private ReaderUtils(){}

    public static String readTextFromFile(String path){
        String text = "";
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            text = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void writeTextToFile(String path, String text){
        File file = new File(path);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))){
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
