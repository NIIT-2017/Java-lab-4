package Staff;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeveloperCompanyTest {
    DeveloperCompany geeks = new DeveloperCompany("Geeks", 180);


    @Test
    public void aTest() {
        geeks.companyCreation("/testStuff.json");
        geeks.addProjects("/testProject.json");
        assertEquals(180,geeks.getBaseRate());
        assertEquals(8, geeks.getNumberOfEmployee());
        geeks.accrualOfSalary();
        assertEquals(0, geeks.getManagers().get(0).getPayment(), 0.1);
    }

    @Test
    public void bTest(){
        geeks.companyCreation("/testStuff.json");
        geeks.addProjects("/testProject.json");
        geeks.assignPerformers();
        geeks.prepareForPayment();
        assertEquals(geeks.getDevelopProjects().get(0).getBudget()*0.05, geeks.getSeniorManager().projectPayment(geeks.getDevelopProjects().get(0)), 0.1);
        assertEquals(geeks.getProgrammers().get(0).projectPayment(), geeks.getTesters().get(0).projectPayment(), 0.1);
        geeks.accrualOfSalary();
        assertEquals(geeks.getCleaners().get(0).getPayment()*1.2, geeks.getDrivers().get(0).getPayment(), 0.1);
        assertEquals(geeks.getDevelopProjects().get(0), geeks.getManagers().get(0).getProject());
        assertEquals(1.15, geeks.getProjectManagers().get(0).managementFee(geeks.getDevelopProjects().get(0)),0.1);

    }

}