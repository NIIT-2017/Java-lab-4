public interface Project {          //Расчет оплаты исходя из участия в проекте
    void setProject(String project);
    void setEmployeeRating(double empRate);
    double paymentFromProject();
}

