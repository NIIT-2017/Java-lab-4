import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonalTest {

    Personal personal = new Personal(1543, "Наумов Игорь Петрович", 18345.87) {
        @Override
        double calc() {
            return 0;
        }

        @Override
        public String toString() {
            return "Personal";
        }
    };

    @org.junit.Test
    public void checkGetBase() {
        assertEquals(18345.87,personal.getBase());
    }

    @org.junit.Test
    public void checkSetBase() {
        personal.setBase(24345.87);
        assertEquals(24345.87,personal.getBase());
    }

    @org.junit.Test
    public void calcWork() {
        assertEquals(10457.145900000001,personal.calcWork(57));
    }
}