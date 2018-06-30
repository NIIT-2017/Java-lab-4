public interface Heading {          //Расчет оплаты исходя из руководства (количества подчиненных)
    void setEmployeeNum(int num);
    void setPaymentForOneEmp(int paymentHeading);
    double paymentFromHeading();
}

