import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


public class Creation {

    Info info;
    ObjectMapper mapper = new ObjectMapper(); //класс, к-й будет считывать json
    File file;

    public Creation() {
        URL resource = getClass().getClassLoader().getResource("info2.json");
        try {
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void projectCreation() {
        try {
            info = mapper.readValue(file, Info.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

