import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class EmployeeTest {

    Employee employee = new Employee(1, "Петров Сергей Львович")
    {
        @Override
        double calc() {
            return 0;
        }

        @Override
        public String toString() {
            return "Employee";
        }
    };


    @org.junit.Test
    public void getId() {
          assertEquals(1,employee.getId());
    }

    @org.junit.Test
     public void setId() {
          employee.setId(777);
          assertEquals(777,employee.getId());
    }

    @org.junit.Test
    public void getName() {
        assertEquals("Петров Сергей Львович",employee.getName());
    }

    @org.junit.Test
    public void setName() {
        employee.setName("Пирогов Платон Эдуардович");
        assertEquals("Пирогов Платон Эдуардович",employee.getName());
    }

    @org.junit.Test
    public void getWorkTime() {
        employee.workTime=123;
        assertEquals(123,employee.getWorkTime());
    }

    @org.junit.Test
    public void setWorkTime() {
        employee.setWorkTime(11);
        assertEquals(11,employee.getWorkTime());
    }

    @org.junit.Test
    public void getPayment() {
        assertEquals(0,employee.getPayment());
    }

    @org.junit.Test
    public void setPayment() {
        employee.setPayment(27893.54);
        assertEquals(27893.54,employee.getPayment());
    }

}