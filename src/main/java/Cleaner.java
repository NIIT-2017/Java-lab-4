import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Cleaner extends Personal implements WorkTime {
    protected String position;

    public Cleaner (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Cleaner () {
    }
    protected void setPosition (String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }

    @Override
    public float calculateSalary() {
        payment = (worktime * rate);
        return payment;
    }
}
