import com.google.gson.annotations.SerializedName;

public class Employee {
    protected int id;
    protected String name;
    protected int workload;
    protected double payment;

    @SerializedName("position")
    protected Position position;
    protected int budget;
    protected int rate;
    protected int personrate;
    protected String project;

    protected double calculatePayment(PaymentHelper paymentHelper) {
        return 0.0;
    };

}
