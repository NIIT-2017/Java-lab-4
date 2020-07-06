package Employees;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Heading {
    @JsonIgnore
    long getSalaryForHeading();
    long getSalaryPerSubordinate();
    void setSalaryPerSubordinate(long salaryPerSubordinate);
}
